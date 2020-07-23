package net.lainiao.dicom.scp.service;

import net.lainiao.dicom.common.storage.StorageCloudUtil;
import net.lainiao.dicom.common.storage.StorageModel;
import net.lainiao.dicom.scp.dicom.DicomModel;
import net.lainiao.dicom.scp.entity.Instance;
import net.lainiao.dicom.scp.entity.Patient;
import net.lainiao.dicom.scp.entity.Series;
import net.lainiao.dicom.scp.entity.Study;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ParseService {
    private static Logger logger = LoggerFactory.getLogger(ParseService.class);
    private static int concurrent = 5;
    private static LinkedBlockingQueue<DicomModel> dicomModelQueue = new LinkedBlockingQueue<>();
    private static Object lockPatientObj = new Object();
    private static Object lockStudyObj = new Object();
    private static Object lockSeriesObj = new Object();
    private static Object lockInstanceObj = new Object();

    public static void addDicomModel(DicomModel dicomModel) {
        try {
            dicomModelQueue.put(dicomModel);
        }
        catch (InterruptedException e) {

        }
    }

    static class TaskRunable implements Runnable {
        private StorageCloudUtil storageCloudUtil = null;
        private PatientService patientService;
        private StudyService studyService;
        private SeriesService seriesService;
        private InstanceService instanceService;

        public TaskRunable(ApplicationContext context) {
            StorageModel storageModel = context.getBean(StorageModel.class);
            this.storageCloudUtil = new StorageCloudUtil(storageModel.getCloudType(), storageModel.getCloudEndPoint(), storageModel.getCloudAccessKeyId(), storageModel.getCloudAccessKeySecret(), storageModel.getCloudBucketName());
            patientService = context.getBean(PatientService.class);
            studyService = context.getBean(StudyService.class);
            seriesService = context.getBean(SeriesService.class);
            instanceService = context.getBean(InstanceService.class);
        }

        @Override
        public void run() {
            DicomModel dicomModel = null;
            try {
                storageCloudUtil.open();
                while ((dicomModel = ParseService.dicomModelQueue.take()) != null) {
                    try {
                        parseDicomFile(dicomModel);
                        String objectName = "dicom/" + dicomModel.getSeriesUid() + "/" + dicomModel.getInstanceNumber() + ".dcm";
                        storageCloudUtil.putObject(objectName, dicomModel.getFile());
                        synchronized (lockInstanceObj) {
                            Instance instance = instanceService.findInstanceByUid(dicomModel.getSopInstanceUid());
                            if (instance == null) {
                                Series series =null;
                                synchronized (lockSeriesObj) {
                                    series = seriesService.findSeriesByUid(dicomModel.getSeriesUid());
                                    if (series == null) {
                                        Study study =null;
                                        synchronized (lockStudyObj) {
                                            study = studyService.findStudyByUid(dicomModel.getStudyUid());
                                            if (study == null) {
                                                Patient patient =null;
                                                synchronized (lockPatientObj) {
                                                    patient = patientService.findPatientByPatientNumber(dicomModel.getPatientNumber());
                                                    if (patient == null) {
                                                        patient = new Patient();
                                                        patient.setBirthDay(dicomModel.getBirthDay());
                                                        patient.setGender(dicomModel.getGender());
                                                        patient.setPatName(dicomModel.getPatientName());
                                                        patient.setPatNumber(dicomModel.getPatientNumber());
                                                        patientService.addPatient(patient);
                                                    }
                                                }
                                                study = new Study();
                                                study.setAccessionNo(dicomModel.getAccessionNo());
                                                study.setModality(dicomModel.getModality());
                                                study.setPatId(patient.getId());
                                                study.setStudyDate(dicomModel.getStudyDate());
                                                study.setStudyUid(dicomModel.getStudyUid());
                                                studyService.addStudy(study);
                                            }
                                        }
                                        series = new Series();
                                        series.setSeriesUid(dicomModel.getSeriesUid());
                                        series.setStudyId(study.getId());
                                        seriesService.addSeries(series);
                                    }
                                }
                                instance = new Instance();
                                instance.setInstanceNum(dicomModel.getInstanceNumber());
                                instance.setInstanceUid(dicomModel.getSopInstanceUid());
                                instance.setObjectName(objectName);
                                instance.setSeriesId(series.getId());
                                instanceService.addInstance(instance);
                            }
                        }
                    }
                    catch (
                            Exception ex) {
                        logger.error("Upload Dicom File Or Storage Info Error", ex);
                    }
                }
            }
            catch (
                    Exception e) {
                logger.error("Open Storage Error:", e);
            }

        }

        private void parseDicomFile(DicomModel dicomModel) throws IOException {
            DicomInputStream inputStream = new DicomInputStream(dicomModel.getFile());
            Attributes attributes = inputStream.readDataset(-1, -1);
            String sopUid = attributes.getString(Tag.SOPInstanceUID);
            String seriesUid = attributes.getString(Tag.SeriesInstanceUID);
            String studyUid = attributes.getString(Tag.StudyInstanceUID);
            String patientName = attributes.getString(Tag.PatientName);
            String patientNum = attributes.getString(Tag.PatientID);
            String birthDay = attributes.getString(Tag.PatientBirthDate);
            String gender = attributes.getString(Tag.PatientSex);
            String studyDate = attributes.getString(Tag.StudyDate);
            String accessionNo = attributes.getString(Tag.AccessionNumber);
            String modality = attributes.getString(Tag.Modality);
            Integer instanceNumber = attributes.getInt(Tag.InstanceNumber, 1);
            dicomModel.setAccessionNo(accessionNo);
            dicomModel.setSopInstanceUid(sopUid);
            dicomModel.setStudyDate(studyDate);
            dicomModel.setStudyUid(studyUid);
            dicomModel.setGender(gender);
            dicomModel.setBirthDay(birthDay);
            dicomModel.setPatientName(patientName);
            dicomModel.setPatientNumber(patientNum);
            dicomModel.setModality(modality);
            dicomModel.setInstanceNumber(instanceNumber);
            dicomModel.setSeriesUid(seriesUid);
            inputStream.close();
        }

    }

    public static void start(ApplicationContext context) {
        ExecutorService service = Executors.newFixedThreadPool(concurrent);
        for (int i = 0; i < concurrent; i++) {
            TaskRunable runable = new TaskRunable(context);
            service.submit(runable);
        }
        logger.info("ParseService Start!");
    }
}

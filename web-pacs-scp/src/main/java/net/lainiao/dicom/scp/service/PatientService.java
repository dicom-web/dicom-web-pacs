package net.lainiao.dicom.scp.service;

import net.lainiao.dicom.scp.dao.PatientMapper;
import net.lainiao.dicom.scp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;
    @Cacheable(cacheNames ="patient",unless = "#result==null")
    public Patient findPatientByPatientNumber(String patientNumber) {
        return patientMapper.findPatientByPatientNumber(patientNumber);
    }

    public int addPatient(Patient patient) {
        return patientMapper.insertPatient(patient);
    }
}

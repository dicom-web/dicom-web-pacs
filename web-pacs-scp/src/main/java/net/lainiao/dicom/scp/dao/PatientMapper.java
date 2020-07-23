package net.lainiao.dicom.scp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Patient;
import net.lainiao.dicom.scp.dao.base.PatientBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface PatientMapper extends PatientBaseMapper{
    Patient findPatientByPatientNumber(String patientNumber);
}
package net.lainiao.dicom.scp.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Patient;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface PatientBaseMapper {

    int insertPatient(Patient object);

    int updatePatient(Patient object);

    int update(Patient.UpdateBuilder object);

    List<Patient> queryPatient(Patient object);

    Patient queryPatientLimit1(Patient object);

}
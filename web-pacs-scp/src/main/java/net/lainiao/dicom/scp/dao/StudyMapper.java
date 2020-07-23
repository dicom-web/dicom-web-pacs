package net.lainiao.dicom.scp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Study;
import net.lainiao.dicom.scp.dao.base.StudyBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface StudyMapper extends StudyBaseMapper{
    Study findStudyByUid(String uid);
}
package net.lainiao.dicom.scp.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Study;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface StudyBaseMapper {

    int insertStudy(Study object);

    int updateStudy(Study object);

    int update(Study.UpdateBuilder object);

    List<Study> queryStudy(Study object);

    Study queryStudyLimit1(Study object);

}
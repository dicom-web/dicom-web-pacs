package net.lainiao.dicom.scp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Instance;
import net.lainiao.dicom.scp.dao.base.InstanceBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface InstanceMapper extends InstanceBaseMapper{
    Instance findInstanceByUid(String uid);
}
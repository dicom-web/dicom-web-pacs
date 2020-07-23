package net.lainiao.dicom.scp.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Instance;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface InstanceBaseMapper {

    int insertInstance(Instance object);

    int updateInstance(Instance object);

    int update(Instance.UpdateBuilder object);

    List<Instance> queryInstance(Instance object);

    Instance queryInstanceLimit1(Instance object);

}
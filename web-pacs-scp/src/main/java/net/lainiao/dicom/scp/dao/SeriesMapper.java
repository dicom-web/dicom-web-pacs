package net.lainiao.dicom.scp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Series;
import net.lainiao.dicom.scp.dao.base.SeriesBaseMapper;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface SeriesMapper extends SeriesBaseMapper{
    Series findSeriesByUid(String uid);
}
package net.lainiao.dicom.scp.dao.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import net.lainiao.dicom.scp.entity.Series;
import org.springframework.stereotype.Repository;

/**
*  @author author
*/
@Repository
public interface SeriesBaseMapper {

    int insertSeries(Series object);

    int updateSeries(Series object);

    int update(Series.UpdateBuilder object);

    List<Series> querySeries(Series object);

    Series querySeriesLimit1(Series object);

}
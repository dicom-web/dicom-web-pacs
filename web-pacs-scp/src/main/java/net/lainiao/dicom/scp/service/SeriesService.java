package net.lainiao.dicom.scp.service;

import net.lainiao.dicom.scp.dao.SeriesMapper;
import net.lainiao.dicom.scp.entity.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {
    @Autowired
    SeriesMapper seriesMapper;

    @Cacheable(cacheNames ="series",unless = "#result==null")
    public Series findSeriesByUid(String seriesUid) {
        return seriesMapper.findSeriesByUid(seriesUid);
    }

    public int addSeries(Series series) {
        return seriesMapper.insertSeries(series);
    }
}

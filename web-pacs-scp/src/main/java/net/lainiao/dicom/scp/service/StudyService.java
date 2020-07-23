package net.lainiao.dicom.scp.service;

import net.lainiao.dicom.scp.dao.StudyMapper;
import net.lainiao.dicom.scp.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
    @Autowired
    StudyMapper studyMapper;
    @Cacheable(cacheNames ="study",unless = "#result==null")
    public Study findStudyByUid(String studyUid) {
        return studyMapper.findStudyByUid(studyUid);
    }

    public int addStudy(Study study) {
        return studyMapper.insertStudy(study);
    }
}

package net.lainiao.dicom.scp.service;

import net.lainiao.dicom.scp.dao.InstanceMapper;
import net.lainiao.dicom.scp.entity.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class InstanceService {
    @Autowired
    InstanceMapper instanceMapper;

    public Instance findInstanceByUid(String sopInstanceUid) {
        return instanceMapper.findInstanceByUid(sopInstanceUid);
    }

    public int addInstance(Instance instance) {
        return instanceMapper.insertInstance(instance);
    }
}

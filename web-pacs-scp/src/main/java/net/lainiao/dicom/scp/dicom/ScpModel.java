package net.lainiao.dicom.scp.dicom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScpModel {

    @Value("${dicom.scp.ae}")
    private String aeTitle;

    @Value("${dicom.scp.port}")
    private Integer port;

    @Value("${dicom.scp.dir}")
    private String dicomDir;

    public String getAeTitle() {
        return aeTitle;
    }

    public void setAeTitle(String aeTitle) {
        this.aeTitle = aeTitle;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDicomDir() {
        return dicomDir;
    }

    public void setDicomDir(String dicomDir) {
        this.dicomDir = dicomDir;
    }
}

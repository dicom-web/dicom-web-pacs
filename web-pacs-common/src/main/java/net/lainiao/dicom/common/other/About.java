package net.lainiao.dicom.common.other;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class About {

    public About(){
        this.version="V1.19.12.11.1.ONLINE";
    }

    private String version = null;
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

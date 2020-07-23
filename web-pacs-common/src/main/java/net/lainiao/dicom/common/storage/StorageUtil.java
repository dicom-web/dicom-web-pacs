package net.lainiao.dicom.common.storage;

import java.io.File;

public interface StorageUtil {
    void open() throws Exception;
    void putObject(String objectName, File file) throws Exception;
    void removeObject(String objectName);
    void close() throws  Exception;
    void getObject(String objectName,File targetFile) throws Exception;
    boolean doesObjectExist(String objectName);
}

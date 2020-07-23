package net.lainiao.dicom.scp.utils;

import java.io.File;
import java.nio.file.Files;

public class CadFileUtils {
    public static void deleteFile(String filePath){
        File file=new File(filePath);
        deleteFile(file);
    }

    private static void deleteFile(File file) {
        if(!file.exists()){
            return;
        }
        if(file.isDirectory()){
            deleteDir(file);
        }
        file.delete();
    }

    private static void deleteDir(File file) {
        File[] files=file.listFiles();
        for(File temFile: files){
            deleteFile(temFile);
        }
    }
}

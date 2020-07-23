package net.lainiao.dicom.scp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.regex.Pattern;

@Component
public class CadUtils {

    public static final int errorCode = -1;
    public static final int successCode = 2;
    private  static final Logger logger = LoggerFactory.getLogger(CadUtils.class);
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

        if(!file.delete()){
            logger.info("Delete File Fail:"+file.getAbsolutePath());
        }
        else{
            logger.info("Deleted File:"+file.getAbsolutePath());
        }
    }

    private static void deleteDir(File file) {
        File[] files=file.listFiles();
        for(File temFile: files){
            deleteFile(temFile);
        }
    }

    public static boolean createDir(String dirPath){
        try {
            File file=new File(dirPath);
            if(file.exists()){
                CadUtils.deleteFile(file);
            }
            return file.mkdirs();
        }
        catch (Exception err) {
            logger.error("CadUtils create dir error",err);
            return false;
        }
    }

    public static String getTableName(String fileName){
        String[] temArr = fileName.split("_");
        String tableName = temArr[temArr.length - 1];
        tableName = tableName.replace(".mhd", "");
        return tableName;
    }

    public static boolean isMultipleMHD(String tableName){
        String pattern = "^.+\\-\\d+$";
        return Pattern.matches(pattern, tableName);
    }


    public static int getMultipleRownumber(String tableName){
        tableName=tableName.replaceAll("\\.mhd","");
        int index=tableName.lastIndexOf("-");
        return Integer.parseInt(tableName.substring(index+1));
    }

    public static String getMultipleTableName(String tableName){
        tableName=tableName.replaceAll("\\.mhd","");
        int index=tableName.lastIndexOf("-");
        return tableName.substring(0,index);
    }

    public static String getFileSuffix(File file){
        String fileName=file.getName();
        if(fileName.indexOf(".")==-1){
            return "";
        }
        String suffix=fileName.substring(fileName.lastIndexOf(".") + 1);
        return suffix;
    }

    public static boolean fileIsImage(String fileName){
        fileName=fileName.toLowerCase();
        if(fileName.endsWith(".jpg")){
            return true;
        }
        if(fileName.endsWith(".png")){
            return true;
        }
        if(fileName.endsWith(".tif")){
            return true;
        }
        if(fileName.endsWith(".bmp")){
            return true;
        }
        return false;
    }


}

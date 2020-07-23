package net.lainiao.dicom.scp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author shl
 * @apiNote 关于Dicom文件的解压和解析分析, 上传的工具
 * @date 2019-03-18
 */
@Component
public class DicomFileHandleUtils {
    private static Logger logger = LoggerFactory.getLogger(DicomFileHandleUtils.class);


    /**
     * 判断压缩包是否是dicom文件
     */
    public static boolean isDicomZip(String dicomUrl) {
        File file = new File(dicomUrl);
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
            is.skip(128);
            byte[] buf = new byte[4];
            is.read(buf);
            String msg_DCM = new String(buf);
            if (msg_DCM.equals("DICM")) {
                return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (is != null) {
                    is.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解压dicom.zip包,解压后文件路径保存在List集合中
     */
    public static List<String> myUnZip(File file, File saveFile) throws Exception {
        String savePath = saveFile.getAbsolutePath() + File.separator;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        //解压后文件路径集合
        List<String> filePathList = new ArrayList<>();
        int count = -1;
        ZipFile zipFile = new ZipFile(file,Charset.forName("gbk"));
        try{
            //解决中文乱码问题
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                byte buf[] = new byte[2048];
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String filename = zipEntry.getName();
                boolean ismkdir = false;
                //检查此文件是否带有文件夹
                if (filename.lastIndexOf("/") == (filename.length() - 1)) {
                    ismkdir = true;
                }
                filename = savePath + filename;
                //如果是文件夹先创建
                if (zipEntry.isDirectory()) {
                    file = new File(filename);
                    file.mkdirs();
                    continue;
                }
                file = new File(filename);
                //如果是目录先创建
                if (!file.exists()) {
                    if (ismkdir) {
                        new File(filename.substring(0, filename.lastIndexOf("/"))).mkdirs();
                    }
                    else {
                        filePathList.add(filename);
                    }
                }
                else {
                    filePathList.add(filename);
                }
                //创建文件
                file.createNewFile();
                inputStream = zipFile.getInputStream(zipEntry);
                fileOutputStream = new FileOutputStream(file);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 2048);
                while ((count = inputStream.read(buf)) > -1) {
                    bufferedOutputStream.write(buf, 0, count);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileOutputStream.close();
                inputStream.close();
            }
        }
        finally {
            try{
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
                if (inputStream != null){
                    inputStream.close();
                }
                if (bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
                if (zipFile != null){
                    zipFile.close();
                }
            }
            catch(Exception e){

            }
        }
        return filePathList;
    }

    /**
     * 删除zip包
     */
    public static void delDicomZip(String url) {
        File file = new File(url);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.getName().endsWith(".zip")) {
                    if (f.delete()) {
                        logger.info("delete already");
                    }
                    else {
                        logger.info("delete failure");
                    }
                }
            }
        }
    }


    /**
     * 循环遍历dicom文件
     */
    public static List<String> getFileList(String strPath) {
        List<String> filelist = new ArrayList<>();
        File dir = new File(strPath);
        if (!dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    String fileName = files[i].getAbsolutePath();
                    filelist.add(fileName);
                }

            }
        }
        return filelist;
    }


}

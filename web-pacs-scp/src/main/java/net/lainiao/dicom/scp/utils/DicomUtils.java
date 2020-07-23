package net.lainiao.dicom.scp.utils;

import java.util.ArrayList;
import java.util.List;

public class DicomUtils {
    public static final int TransferSyntaxUID = 0x00020010;
    private static List<String> processUIDs = new ArrayList<String>();
    static{
        processUIDs.add("1.2.840.10008.1.2.4.50");
        processUIDs.add("1.2.840.10008.1.2.4.51");
        processUIDs.add("1.2.840.10008.1.2.4.57");
        processUIDs.add("1.2.840.10008.1.2.4.58");
        processUIDs.add("1.2.840.10008.1.2.4.70");
        processUIDs.add("1.2.840.10008.1.2.4.80");
        processUIDs.add("1.2.840.10008.1.2.4.81");
        processUIDs.add("1.2.840.10008.1.2.4.90");
        processUIDs.add("1.2.840.10008.1.2.4.91");
        processUIDs.add("1.2.840.10008.1.2.4.92");
        processUIDs.add("1.2.840.10008.1.2.4.93");
    }
//
//    public static boolean isDicomCompress(File dicomFile){
//        FileInputStream inputStream = null;
//        DicomInputStream dicomInputStream = null;
//        DicomObject dicomObject;
//        try {
//            inputStream = new FileInputStream(dicomFile);
//            dicomInputStream = new DicomInputStream(inputStream);
//            dicomObject = dicomInputStream.readDicomObject();
//            String tagValue = getString(TransferSyntaxUID, dicomObject);
//            if(processUIDs.contains(tagValue)){
//                return true;
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//        } finally {
//            try {
//                if (dicomInputStream != null) {
//                    dicomInputStream.close();
//                }
//                if (dicomInputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//
//            }
//        }
//        return false;
//    }


//    public static String getString(int tag, DicomObject dicomObject) {
//
//        byte[] byteTagValue = dicomObject.getBytes(tag);
//        // 如果获取的byte值为空,则返回null;如果不为空,则根据不同的字符编码集进行对应处理.
//        if (null == byteTagValue) {
//            return null;
//        }
//        else {
//            SpecificCharacterSet characterSet = dicomObject.getSpecificCharacterSet();
//            String tagValue = null;
//            String unicodeTagValue = null;
//
//            try {
//                if (null == characterSet) {
//                    unicodeTagValue = new String(byteTagValue, "GBK");
//                }
//                else {
//                    unicodeTagValue = characterSet.decode(byteTagValue);
//                }
//                byte[] utfBytes = unicodeTagValue.getBytes("UTF-8");
//                tagValue = new String(utfBytes, "UTF-8");
//            }
//            catch (Exception e) {
//
//            }
//            return tagValue;
//        }
//    }
}

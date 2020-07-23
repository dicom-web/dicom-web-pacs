package net.lainiao.dicom.common.utils;

import java.util.UUID;

public class OtherUtils {
    public static String newUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}

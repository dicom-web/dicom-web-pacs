package net.lainiao.dicom.scp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author shl
 * @Date 2020/4/3
 */
public class DateUtils {
    //将时间格式化
    public static String getFormatDate(Date date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }

}

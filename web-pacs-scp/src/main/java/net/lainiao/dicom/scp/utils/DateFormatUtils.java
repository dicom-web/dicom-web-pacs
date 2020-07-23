package net.lainiao.dicom.scp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shl
 * @apiNote 时间处理工具
 * */
public class DateFormatUtils {

    private static Logger logger = LoggerFactory.getLogger(DateFormatUtils.class);

    /**
     * 获取当前时间前几天的时间
     * */
    public static String getBeforTime(Integer day){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        //几小时之前的时间
        calendar.add(Calendar.HOUR_OF_DAY, - (day * 24));
        Date date = calendar.getTime();
        String time = simpleDateFormat.format(date);
        return time;
    }
}

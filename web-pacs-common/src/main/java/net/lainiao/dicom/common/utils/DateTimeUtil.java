package net.lainiao.dicom.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author shl
 * @apiNote 关于时间的工具类
 * */
public class DateTimeUtil {

    /**
     * 月
     * */
    private static final long ONE_MONTH_MILLISECONDS = 30L * 24 * 60 * 60 * 1000;

    /**
     * 日
     * */
    private static final long ONE_DAY_MILLISECONDS = 24 * 60 * 60 * 1000;

    /**
     * 时
     * */
    private static final long ONE_HOUR_MILLISECONDS = 60 * 60 * 1000;

    /**
     * 计算时间毫秒数
     * */
    public static long timeToMillisecond(Integer expirationDays, Integer unit){

        long millisecond = 0l;
        Date date = new Date();
        Date nextMonth = null;
        //单位(1月，2日，3时)
        if (expirationDays != null && unit != null){
            if (unit == 1){//默认30天
                nextMonth = new Date(date.getTime() + expirationDays * ONE_MONTH_MILLISECONDS);
            }else if (unit == 2){
                nextMonth = new Date(date.getTime() + expirationDays * ONE_DAY_MILLISECONDS);
            }else if (unit == 3){
                nextMonth = new Date(date.getTime() + expirationDays * ONE_HOUR_MILLISECONDS);
            }
            millisecond = nextMonth.getTime();
        }
        return millisecond;
    }

    /**
     * LocalDatetime 转字符串
     * */
    public static String LocalDateTimeToString(LocalDateTime localDateTime){
        String time = null;
        if (localDateTime != null){
            time = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(timeToMillisecond(3,1));
    }
}

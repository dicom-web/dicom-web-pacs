package net.lainiao.dicom.scp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class OtherUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final ZoneId zone = ZoneId.systemDefault();

    public static String newUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        OtherUtils.applicationContext = applicationContext;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        OtherUtils.applicationContext = context;
    }

    public static Date LocalTimeToDate(LocalDateTime localDateTime){
        ZonedDateTime zdt = localDateTime.atZone(zone);
        return Date.from(zdt.toInstant());
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), zone);
    }

    public static Integer getAge(String birth) {
        try {
            if (birth.length() == 8) {
                Date date = simpleDateFormat.parse(birth);
                return getAge(date);
            }
        } catch (Exception err) {

        }
        return null;
    }

    public static Integer getAge(Date date) {
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date()); // 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(date); // 传入的时间

            //如果传入的时间，在当前时间的后面，返回0岁
            if (birth.after(now)) {
                return null;
            } else {
                int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
                return age;
            }

        }
        catch (Exception e) {

        }
        return null;
    }
}

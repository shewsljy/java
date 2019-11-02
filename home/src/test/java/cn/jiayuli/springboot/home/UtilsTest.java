package cn.jiayuli.springboot.home;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsTest {
    @Test
    public void lang3DateUtils() throws Exception{
        Date date1 = new Date();
        System.out.println(date1);
        Instant instant = date1.toInstant();
        System.out.println(instant);
        Date date2 = DateUtils.parseDate("2019-08-20 19:23:32","yyyy-MM-dd HH:mm:ss");
        System.out.println(date2);
        DateFormat dateFormat = DateFormat.getInstance();
        System.out.println(dateFormat.format(date1));
        DateFormat dateFormatTime = DateFormat.getTimeInstance();
        System.out.println(dateFormatTime.format(date1));
        DateFormat dateFormatDate = DateFormat.getDateInstance();
        System.out.println(dateFormatDate.format(date1));
        DateFormat dateFormatDateAndTime = DateFormat.getDateTimeInstance();
        System.out.println(dateFormatDateAndTime.format(date1));
        SimpleDateFormat df = new SimpleDateFormat();
        System.out.println(df.format(date1));
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date1));
        System.out.println(df.parse("2018-05-12 10:23:42"));
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(df.format(date1));
        Date date3 = DateUtils.addDays(date1, -30);
        System.out.println(df.format(date3));
        Timestamp timestamp1 = Timestamp.valueOf(df.format(date1));
        System.out.println(timestamp1);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2);
        //
        Date date001 = new Date();
        SimpleDateFormat df001 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date002 = DateUtils.parseDate("2019-10-13 23:59:59","yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp001 = Timestamp.valueOf(df001.format(date001));
        System.out.println(date001);
        System.out.println(date002);
        System.out.println(timestamp001);
        String timestampStr =df001.format(timestamp001).split(" ")[0] + " 23:59:59";
        System.out.println(timestampStr);
        Date date003 = DateUtils.parseDate(timestampStr,"yyyy-MM-dd HH:mm:ss");
        System.out.println(date003);
        int days = daysBetween(date002,date003);
        System.out.println(days);
    }

    public static int daysBetween(java.util.Date date1, java.util.Date date2) {
        long number = date2.getTime() - date1.getTime();
        if (number < 0){
            return -1;
        }
        long between_days = number / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    @Test
    public void lang3Validate() {
        Date date = new Date();
        Validate.isTrue(date != null, "The date must not be null");
        Validate.notNull(date, "The date must not be null");
        List<String> list = new ArrayList<String>();
        list.add("sub");
        Validate.notEmpty(list, "The list must not be empty");
    }

}

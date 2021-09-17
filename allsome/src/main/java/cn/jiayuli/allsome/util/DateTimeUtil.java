package cn.jiayuli.allsome.util;

import cn.jiayuli.allsome.constant.DateTimeFormatConstant;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String getDataTimeAsString(LocalDateTime localDateTime) {
        return getDataTimeAsString(localDateTime,DateTimeFormatConstant.DEFAULT_DATE_TIME_FORMAT);
    }

    public static String getDataTimeAsString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static LocalDateTime getDataTimeOfTimestamp(Long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zoneId = ZoneId.of(DateTimeFormatConstant.DEFAULT_TIME_ZONE_GMT8);
        return LocalDateTime.ofInstant(instant,zoneId);
    }

    public static Long getTimestampOfDataTime(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.of(DateTimeFormatConstant.DEFAULT_TIME_ZONE_GMT8);
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return instant.toEpochMilli();
    }

    public static LocalDateTime parseStringToDataTime(String time) {
        return parseStringToDataTime(time,DateTimeFormatConstant.DEFAULT_DATE_TIME_FORMAT);
    }

    public static LocalDateTime parseStringToDataTime(String time, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time,formatter);
    }
}

package v1ch04.calendar;

import java.time.LocalDate;
import java.time.DayOfWeek;

/**
 * @author jiayu
 * @description
 * @date 2018/2/8 11:33
 */
public class Calendar {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/8 17:57
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {

        //取得当前日期
        LocalDate date = LocalDate.now();
        //取得日 月。
        // getMonthValue() 获取当前日期是第几月
        int month = date.getMonthValue();
        // getDayOfMonth() 表示该对象表示的日期是这个月第几天
        int today = date.getDayOfMonth();
        System.out.println("当前日期为: " + month + "月" + today + "日");

        //minusDays() 当前对象减去指定的天数，today - 1 是为了得到当月的1日
        date = date.minusDays(today - 1);
        //getDayOfWeek() 该对象表示的日期是星期几，在这里表示当月的1日是星期几
        DayOfWeek weekday = date.getDayOfWeek();
        //getValue() 该对象表示的日期是这个星期的第几天，从 1 (Monday) 到 7 (Sunday)
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //当月1日之前的日期打四个空格
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        //日期的天数进行累加，还在当月范围则继续
        while (date.getMonthValue() == month)
        {
            //格式化(3字符)输出当前日期是第几天
            System.out.printf("%3d", date.getDayOfMonth());
            //如果日期到了当天，打一个*号，否则打空格
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
            //plusDays() 当前对象增加指定的天数，这里加一天
            date = date.plusDays(1);
            //如果当前的日期是周一，换行
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        //跳出循环后，如果当前的日期不是周一，换行
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}

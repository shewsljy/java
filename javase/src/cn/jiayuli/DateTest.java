package cn.jiayuli;

import java.util.Date;

/**
 * @author jiayu
 * @description
 * @date 2018/2/8 16:00
 */
public class DateTest {
    /**
     * @description 
     * @author jiayu
     * @date 2018/2/8 17:07
     * @param [args]
     * @return void
     */
    public static void main(String[] args) {
        Date date = new Date();
        //getTime() 获取当前时间毫秒数，toString() 获取当前时间格式化输出
        System.out.println("now date: " + date);
        System.out.println("now date.toString(): " + date.toString());
        System.out.println("now date.getTime(): " + date.getTime());

        //setTime() 设置离起点的毫秒时间 10分钟
        Date changeDate = new Date();
        changeDate.setTime(1000 * 60 * 10);
        System.out.println("change date: " + changeDate);

        //before() 时间比对，该时间是否在比对时间之前
        System.out.println("changeDate是否在当前时间之前: " + changeDate.before(date));
        //after() 时间比对，该时间是否在比对时间之后
        System.out.println("changeDate是否在当前时间之后: " + changeDate.after(date));
    }
}

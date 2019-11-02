package cn.jiayuli.springboot.home;

import org.junit.Test;

public class SystemTest {

    public static void main(String[] args){
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(System.getProperty("java.library.path"));
        int i = 5;
        System.out.println("i = " + i);
        System.out.println("i = " + i++);
        System.out.println("i = " + --i);
        System.out.println("i = " + i--);
        System.out.println("i = " + ++i);

        StringBuffer chnl = new StringBuffer();
        chnl.append("【单品编号:12345,渠道编码:54321】、");
//        chnl.append("【单品编号:23456,渠道编码:65432】、");
//        chnl.append("【单品编号:34567,渠道编码:76543】、");
        int count = chnl.lastIndexOf("、");
        System.out.println(count);
        System.out.println(chnl.toString());
        if (count > 0){
            chnl.deleteCharAt(count);
        }
        System.out.println(chnl.toString());
    }
}

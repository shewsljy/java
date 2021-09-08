package cn.jiayuli.wechat.util;

public class MessageUtil {
    public static String addCData(String str) {
        String result = "<![CDATA[" + str + "]]>";
        return result;
    }
}

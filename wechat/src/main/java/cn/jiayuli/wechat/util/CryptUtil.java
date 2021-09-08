package cn.jiayuli.wechat.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class CryptUtil {

    public static String signature(String ... args) {
        String signature = "";
        Arrays.sort(args);
        StringBuffer buffer = new StringBuffer();
        for (String arg : args) {
            buffer.append(arg);
        }
        String str = buffer.toString();
        signature = DigestUtils.sha1Hex(str);
        return signature;
    }

}

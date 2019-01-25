package cn.jiayuli.exception;

import java.security.MessageDigest;
import java.util.Arrays;

public class EncryptUtil {

    public static String SHA1Encrypt(String[] array) throws AesException {

        // 排序字符串
        Arrays.sort(array);

        // 将排序后的字符串拼接成一个字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            stringBuffer.append(array[i]);
        }
        String string = stringBuffer.toString();

        // SHA1签名生成
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(string.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer hexStr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
                int a = 2/0;
            }
            return hexStr.toString();
        }catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
}

package cn.jiayuli.allsome.util;

import cn.jiayuli.allsome.constant.DigestConstant;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Util {
    public static String MD5Pwd(String username, String pwd) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数
        String md5Pwd = new SimpleHash(DigestConstant.ALGORITHM_NAME_MD5, pwd,
                ByteSource.Util.bytes(username + DigestConstant.STRING_SALT), DigestConstant.HASH_ITERATIONS_1024).toHex();
        return md5Pwd;
    }
}

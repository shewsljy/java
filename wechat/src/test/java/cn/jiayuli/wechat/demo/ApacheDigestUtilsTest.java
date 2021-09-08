package cn.jiayuli.wechat.demo;

import cn.jiayuli.wechat.util.CryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ApacheDigestUtilsTest {

    @Test
    void springDigestUtilsTest() {
        String helloStr = "哈喽";//
        log.info("hello string : {}", helloStr);
        byte[] helloByte = helloStr.getBytes();//
        log.info("hello byte : {}", helloByte);
        byte[] helloMd5Digest1 = DigestUtils.md5(helloByte);
        log.info("hello md5Digest1 : {}", helloMd5Digest1);
        byte[] helloMd5Digest2 = DigestUtils.md5(helloStr);
        log.info("hello md5Digest2 : {}", helloMd5Digest2);
        String helloMd5DigestAsHex1 = DigestUtils.md5Hex(helloByte);
        log.info("hello md5DigestAsHex1 : {}", helloMd5DigestAsHex1);
        String helloMd5DigestAsHex2 = DigestUtils.md5Hex(helloStr);
        log.info("hello md5DigestAsHex2 : {}", helloMd5DigestAsHex2);//492389292f5e200f6d1518055b0b1755
    }

    @Test
    void wxCryptUtilTest() {
        //signature=454d7c76021228db7b739e583b13e879aafe3837,
        // timestamp=1621489920, nonce=1078917183, echostr=7950995497998089530
        // token=token_dev_123
        String token = "token_dev_123";
        String timestamp = "1621489920";
        String nonce = "1078917183";
        String signature = CryptUtil.signature(token,timestamp,nonce);
        log.info("signature = {}",signature);
    }
}

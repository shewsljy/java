package cn.jiayuli.wechat.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@Slf4j
@SpringBootTest
public class SpringDigestUtilsTest {

    @Test
    void springDigestUtilsTest() {
        String helloStr = "哈喽";
        log.info("hello string : {}", helloStr);
        byte[] helloByte = helloStr.getBytes();
        log.info("hello byte : {}", helloByte);
        byte[] helloMd5Digest = DigestUtils.md5Digest(helloByte);
        log.info("hello md5Digest : {}", helloMd5Digest);
        String helloMd5DigestAsHex = DigestUtils.md5DigestAsHex(helloByte);
        log.info("hello md5DigestAsHex : {}", helloMd5DigestAsHex);//492389292f5e200f6d1518055b0b1755
    }
}

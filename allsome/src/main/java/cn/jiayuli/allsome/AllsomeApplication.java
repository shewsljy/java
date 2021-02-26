package cn.jiayuli.allsome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jiayuli.allsome.mapper")
public class AllsomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllsomeApplication.class, args);
    }

}

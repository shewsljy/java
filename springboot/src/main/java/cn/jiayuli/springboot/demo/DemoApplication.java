package cn.jiayuli.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    public String velocityTest(Map map) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("message", "这是Demo的内容。。。");
        map.put("toUserName", "张三");
        map.put("fromUserName", "李四");
        map.put("time", dateFormat.format(date));
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

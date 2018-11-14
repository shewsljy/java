package cn.jiayuli.dubbo.demo.main;

import cn.jiayuli.dubbo.demo.interfaces.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) throws IOException {
        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        DemoService demoService = (DemoService)context.getBean("demoService");
        System.out.println("consumer");
        System.out.println(demoService.getPermissions(1L));
        System.in.read();
    }
}

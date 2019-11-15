package cn.jiayuli.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ClassName: DemoMain <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/11/14
 */
public class DemoProviderMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, Demo! This is provider!");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/dubbo-provider.xml");
        context.start();
        System.out.println("服务已经启动...");
        System.out.println("按任意键退出");
        System.in.read();
    }
}

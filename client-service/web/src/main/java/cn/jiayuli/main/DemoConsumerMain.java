package cn.jiayuli.main;

import cn.jiayuli.common.client.service.demo.DemoSIDSV;
import cn.jiayuli.common.client.vo.demo.DemoVO;
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
public class DemoConsumerMain {

    public static void main(String[] args) throws IOException {
        //测试Demo服务
        System.out.println("Hello, Demo! This is consumer!");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/dubbo-consumer.xml");
        context.start();
        System.out.println("服务已经启动...");
        System.out.println("按任意键退出");
        System.out.println("取得远程DemoSIDSV服务...");
        DemoSIDSV demoSIDSV = (DemoSIDSV)context.getBean("demoSIDSV");
        System.out.println("调用远程DemoSIDSV服务的queryAppName方法...");
        DemoVO demoVO = demoSIDSV.queryAppName();
        System.out.println(demoVO);
        System.in.read();
    }
}

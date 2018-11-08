package spring;

import cn.jiayuli.spring.interfaces.Hello;
import cn.jiayuli.spring.services.HelloService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloServiceTest {
    @Test
    public void testHello() {
        //1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        //根据名称和指定的类型返回一个Bean，客户端无需自己进行类型转换，如果类型转换失败，容器抛出异常
        //Hello hello = context.getBean("hello", Hello.class);
        //根据名称返回一个Bean，客户端需要自己进行类型转换
        HelloService helloService = (HelloService) context.getBean("helloService");
        //3、执行业务逻辑
        Hello hello = helloService.getHello();
        hello.sayHello();
    }
}

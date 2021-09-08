package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.Hello;
import cn.jiayuli.spring.services.HelloService;

public class HelloServiceImpl implements HelloService {

    private Hello hello;

    public HelloServiceImpl() {

    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}

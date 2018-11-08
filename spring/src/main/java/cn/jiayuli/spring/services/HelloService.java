package cn.jiayuli.spring.services;

import cn.jiayuli.spring.interfaces.Hello;

public class HelloService {
    private Hello hello;
    public HelloService() {

    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}

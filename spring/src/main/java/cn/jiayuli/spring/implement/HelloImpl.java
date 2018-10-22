package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.HelloApi;

public class HelloImpl implements HelloApi {
    @Override
    public void sayHello(){
        System.out.println("Hello World!");
    }
}

package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.Hello;

public class HelloJava implements Hello {
    @Override
    public void sayHello(){
        System.out.println("Hello World, Java!");
    }
}

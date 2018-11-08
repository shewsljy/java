package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.Hello;

public class HelloPython implements Hello {
    @Override
    public void sayHello(){
        System.out.println("Hello World, Python!");
    }
}

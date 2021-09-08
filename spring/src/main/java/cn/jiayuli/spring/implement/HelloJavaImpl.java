package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.Hello;

public class HelloJavaImpl implements Hello {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{ HelloJava } : " + name;
    }

    @Override
    public void sayHello(){
        System.out.println("Hello World, Java!");
    }
}

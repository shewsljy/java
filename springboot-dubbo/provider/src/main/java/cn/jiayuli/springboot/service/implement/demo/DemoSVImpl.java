package cn.jiayuli.springboot.service.implement.demo;

import cn.jiayuli.springboot.service.interfaces.demo.DemoSV;
import org.springframework.stereotype.Service;

@Service
public class DemoSVImpl implements DemoSV {

    @Override
    public String sayHello(String name){
        return "Hello " + name + " !";
    }

    @Override
    public String sayGoodbye(String name){
        return "Goodbye " + name + " !";
    }
}

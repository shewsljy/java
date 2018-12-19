package cn.jiayuli.springboot.dubbo.implement.demo;

import cn.jiayuli.springboot.dubbo.interfaces.demo.DemoService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name){
        return "Hello " + name + " !";
    }
    @Override
    public String sayGoodbye(String name){
        return "Goodbye " + name + " !";
    }
}

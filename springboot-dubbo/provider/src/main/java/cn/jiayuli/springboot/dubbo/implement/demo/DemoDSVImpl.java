package cn.jiayuli.springboot.dubbo.implement.demo;

import cn.jiayuli.springboot.dubbo.interfaces.demo.DemoDSV;
import cn.jiayuli.springboot.service.interfaces.demo.DemoSV;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service
public class DemoDSVImpl implements DemoDSV {

    @Resource
    private DemoSV demoSV;

    @Override
    public String sayHello(String name){
        return demoSV.sayHello(name);
    }

    @Override
    public String sayGoodbye(String name){
        return demoSV.sayGoodbye(name);
    }
}

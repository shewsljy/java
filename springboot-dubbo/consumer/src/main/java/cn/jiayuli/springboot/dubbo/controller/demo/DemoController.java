package cn.jiayuli.springboot.dubbo.controller.demo;

import cn.jiayuli.springboot.dubbo.interfaces.demo.DemoDSV;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference
    private DemoDSV demoDSV;

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable String name){
        return demoDSV.sayHello(name);
    }

    @GetMapping("goodbye/{name}")
    public String sayGoodbye(@PathVariable String name){
        return demoDSV.sayGoodbye(name);
    }

}

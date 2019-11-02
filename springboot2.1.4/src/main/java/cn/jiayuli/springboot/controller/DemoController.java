package cn.jiayuli.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public List<String> demo(){
        String demo = "Hello, World!";
        List<String> strings = new ArrayList<String>();
        strings.add("123");
        strings.add("456");
        strings.add("789");
        strings.add(demo);
        return strings;
    }
}

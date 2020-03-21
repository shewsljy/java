package cn.jiayuli.springbootcxf.controller;

import cn.jiayuli.springbootcxf.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: DemoController <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("")
    public String printDemo() {
        return demoService.printDemo("springboot");
    }
}

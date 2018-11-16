package cn.jiayuli.myhome.demo.controller;

import cn.jiayuli.myhome.demo.service.DemoUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/demo/user")
public class DemoUserInfoController {
    @Resource
    private DemoUserInfoService demoUserInfoService;

    @RequestMapping("/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        model.addAttribute("user", demoUserInfoService.queryUserInfoById(id));
        return "demo/user/detail";
    }

}

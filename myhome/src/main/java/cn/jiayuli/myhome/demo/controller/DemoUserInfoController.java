package cn.jiayuli.myhome.demo.controller;

import cn.jiayuli.myhome.demo.model.DemoUserInfo;
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
        DemoUserInfo demoUserInfo = demoUserInfoService.queryUserInfoById(id);
        model.addAttribute("user", demoUserInfo);
        return "demo/user/detail";
    }

    @RequestMapping("/list")
    public String getUserInfoList(Model model) {
        List<DemoUserInfo> demoUserInfoList = new ArrayList<DemoUserInfo>();
        demoUserInfoList = demoUserInfoService.queryUserInfoAll();
        model.addAttribute("users", demoUserInfoList);
        return "demo/user/list";
    }

}

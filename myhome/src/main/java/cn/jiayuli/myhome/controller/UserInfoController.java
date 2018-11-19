package cn.jiayuli.myhome.controller;

import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        UserInfo userInfo = userInfoService.queryUserInfoById(id);
        model.addAttribute("user", userInfo);
        return "user/detail";
    }

    @RequestMapping("/list")
    public String getUserInfoList(Model model) {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        userInfoList = userInfoService.queryUserInfoAll();
        model.addAttribute("users", userInfoList);
        return "user/list";
    }

}

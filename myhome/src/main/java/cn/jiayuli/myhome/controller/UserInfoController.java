package cn.jiayuli.myhome.controller;

import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getUserInfo(@PathVariable("id") Long id, Model model) {
        UserInfo userInfo = userInfoService.queryUserInfoById(id);
        model.addAttribute("user", userInfo);
        return "user/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String getUserInfoList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                  Model model) {
        PageInfo<UserInfo> pageUserInfo = userInfoService.queryUserInfoAllPage(pageNo, pageSize);
        model.addAttribute("pageUserInfo", pageUserInfo);
        return "user/list";
    }

}

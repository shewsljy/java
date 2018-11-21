package cn.jiayuli.myhome.controller;

import cn.jiayuli.myhome.model.UserInfo;
import cn.jiayuli.myhome.service.UserInfoService;
import cn.jiayuli.myhome.util.ConstantsUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

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
    public String getUserInfoList(@RequestParam(value = "pageNo", defaultValue = ConstantsUtil.PAGEINFO.USER_INFO_PAGE_NO) int pageNo,
                                  @RequestParam(value = "pageSize", defaultValue = ConstantsUtil.PAGEINFO.USER_INFO_PAGE_SIZE) int pageSize,
                                  Model model) {
        PageInfo<UserInfo> pageUserInfo = userInfoService.queryUserInfoAllPage(pageNo, pageSize);
        model.addAttribute("pageUserInfo", pageUserInfo);
        return "user/list";
    }

}

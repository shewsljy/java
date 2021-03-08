package cn.jiayuli.allsome.controller;

import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public String getUser(@RequestParam("code")String code) {

        UserDTO userDTO = userService.queryUserByCode(code);
        if (ObjectUtils.isEmpty(userDTO)) {
            return "用户 : " + code + " 在系统不存在。";
        }
//        userDTO.setPassword("");
        return "用户 : " + userDTO.toString();
    }

    @PostMapping("/user")
    @ResponseBody
    public String postUser(@RequestParam("name")String name,
                           @RequestParam("code")String code,
                           @RequestParam("age")Integer age,
                           @RequestParam("password")String password) {

        boolean isUnique = userService.checkLoginNameUnique(code);
        if (!isUnique) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(name);
            userDTO.setCode(code);
            userDTO.setAge(age);
            userDTO.setPassword(password);
            int count = userService.addUser(userDTO);
            if (count < 1) {
                return "用户 : " + code + " 新增失败。";
            }
            userDTO = userService.queryUserByCode(code);
            return "新增用户 : " + userDTO.toString();
        }
        return "用户 : " + code + " 在系统已存在。";
    }
}

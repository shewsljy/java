package cn.jiayuli.allsome.controller;

import cn.jiayuli.allsome.annotation.ResponseResult;
import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.result.ResultCode;
import cn.jiayuli.allsome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseResult
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserDTO getUser(@RequestParam("code")String code) {
        UserDTO userDTO = userService.queryUserByCode(code);
        if (userDTO == null) {
            throw new ApiException(ResultCode.USER_NOT_EXIST);
        }
        return userDTO;
    }

//    @GetMapping("/user")
//    public String getUser(@RequestParam("code")String code) {
//        UserDTO userDTO = userService.queryUserByCode(code);
//        if (userDTO == null) {
//            throw new ApiException(ResultCode.USER_NOT_EXIST);
//        }
//        return userDTO.toString();
//    }

    @PostMapping("/user")
    @ResponseBody
    public String postUser(@RequestParam("name")String name,
                           @RequestParam("code")String code,
                           @RequestParam("age")Integer age,
                           @RequestParam("password")String password) {

        boolean isUnique = userService.checkUserCodeUnique(code);
        if (isUnique) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(name);
            userDTO.setCode(code);
            userDTO.setAge(age);
            userDTO.setPassword(password);
            int count = userService.addUser(userDTO);
            if (count < 1) {
                return "用户 : " + code + " 新增失败。";
            }
            return "新增用户 : " + code + " 成功。";
        }
        return "用户 : " + code + " 在系统已存在。";
    }

    @PostMapping("/user/changePassword")
    @ResponseBody
    public String changePassword(@RequestParam("code")String code,
                           @RequestParam("password_old")String password_old,
                           @RequestParam("password_new")String password_new) {

        boolean isUnique = userService.checkUserCodeUnique(code);
        if (isUnique) {
            return "用户 : " + code + " 在系统不存在。";
        }
        boolean isChange = userService.changePassword(code,password_old,password_new);
        if (isChange) {
            return "用户 : " + code + " 更新密码成功。";
        }
        return "用户 : " + code + " 更新密码失败。";
    }
}

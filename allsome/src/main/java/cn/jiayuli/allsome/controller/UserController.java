package cn.jiayuli.allsome.controller;

import cn.jiayuli.allsome.annotation.ResponseResult;
import cn.jiayuli.allsome.dto.UserDTO;
import cn.jiayuli.allsome.exception.ApiException;
import cn.jiayuli.allsome.result.Result;
import cn.jiayuli.allsome.result.ResultCode;
import cn.jiayuli.allsome.service.LoginService;
import cn.jiayuli.allsome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseResult
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping()
    public Result getUser(@RequestParam("code")String code) {
        UserDTO userDTO = userService.queryUserByCode(code);
        if (userDTO == null) {
            throw new ApiException(ResultCode.USER_NOT_EXIST);
        }
        return Result.success(userDTO);
    }

    @GetMapping("/count")
    public Result getUserCount() {
        Integer count = loginService.userCount();
        return Result.success(count);
    }

    @PostMapping()
    public Result postUser(@RequestParam("name")String name,
                           @RequestParam("code")String code,
                           @RequestParam("age")Integer age,
                           @RequestParam("password")String password) {

        boolean isUnique = userService.checkUserCodeUnique(code);
        if (isUnique) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(name);
            userDTO.setUserCode(code);
            userDTO.setUserAge(age);
            userDTO.setUserPasswd(password);
            int count = userService.addUser(userDTO);
            if (count < 1) {
                return new Result(ResultCode.USER_CREATE_FAIL);
            }
            return Result.success(userDTO);
        }
        return new Result(ResultCode.USER_EXIST);
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestParam("code")String code,
                           @RequestParam("password_old")String password_old,
                           @RequestParam("password_new")String password_new) {

        boolean isUnique = userService.checkUserCodeUnique(code);
        if (isUnique) {
            return new Result(ResultCode.USER_NOT_EXIST);
        }
        boolean isChange = userService.changePassword(code,password_old,password_new);
        if (isChange) {
            return Result.success();
        }
        return new Result(ResultCode.USER_CHANGE_PW_FAIL);
    }
}

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
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/user")
    public UserDTO getUser(@RequestParam("code")String code) {
        UserDTO userDTO = userService.queryUserByCode(code);
        if (userDTO == null) {
            throw new ApiException(ResultCode.USER_NOT_EXIST);
        }
        return userDTO;
    }

//    @GetMapping("/user/test")
//    public String getUserTest(@RequestParam("code")String code) {
//        UserDTO userDTO = userService.queryUserByCode(code);
//        if (userDTO == null) {
//            throw new ApiException(ResultCode.USER_NOT_EXIST);
//        }
//        return userDTO.toString();
//    }
    @GetMapping("/goods/count")
    public Result getGoodsCount() {
        Integer count = loginService.goodsCount();
        return Result.success(count);
    }

    @PostMapping("/user")
    public Result postUser(@RequestParam("name")String name,
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
                return new Result(ResultCode.USER_CREATE_FAIL);
            }
            return Result.success(userDTO);
        }
        return new Result(ResultCode.USER_EXIST);
    }

    @PostMapping("/user/changePassword")
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

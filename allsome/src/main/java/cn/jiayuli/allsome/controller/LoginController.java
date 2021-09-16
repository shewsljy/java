package cn.jiayuli.allsome.controller;

import cn.jiayuli.allsome.annotation.ResponseResult;
import cn.jiayuli.allsome.result.Result;
import cn.jiayuli.allsome.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
@ResponseResult
@RequestMapping("/login")
@ApiIgnore
public class LoginController {

    @GetMapping()
    public String getLogin(){
        log.info("login!");
        return "login/login";
    }

    @PostMapping()
    public Result postLogin(@RequestParam("code")String code,
                            @RequestParam("password")String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(code,password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return new Result(ResultCode.USER_NOT_EXIST);
        } catch (IncorrectCredentialsException ice) {
            return new Result(ResultCode.USER_LOGIN_PW_FAIL);
        } catch (LockedAccountException lae) {
            return new Result(ResultCode.USER_LOCKED);
        } catch (ExcessiveAttemptsException eae) {
            return new Result(ResultCode.USER_LOGIN_COUNT_FAIL);
        } catch (AuthenticationException ae) {
            return new Result(ResultCode.USER_LOGIN_PW_FAIL);
        }
        if (subject.isAuthenticated()) {
            return Result.success(code);
        } else {
            token.clear();
            return new Result(ResultCode.USER_LOGIN_FAIL);
        }
    }
}

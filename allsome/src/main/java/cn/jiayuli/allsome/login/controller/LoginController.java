package cn.jiayuli.allsome.login.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        log.info("login!");
        return "login/login";
    }
}

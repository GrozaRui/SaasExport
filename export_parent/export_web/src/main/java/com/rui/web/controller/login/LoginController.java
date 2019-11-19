package com.rui.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 跳转主页
 * @author: caihongrui
 * @createtime: 2019-11-15 16:14
 **/
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "home/main";
    }

    @RequestMapping("/home")
    public String toHomePage() {
        return "home/home";
    }
}

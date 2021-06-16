package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 在controller中对登录和注销方法进行调用
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String login(String username, String password) {
        return loginService.login(username, password);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        return loginService.logout(httpServletRequest);
    }


}

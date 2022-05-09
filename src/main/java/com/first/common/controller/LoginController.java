package com.first.common.controller;

import com.first.common.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService service;

    @GetMapping("/login")
    public String userLogin()
    {
        return "/user/login";
    }
}

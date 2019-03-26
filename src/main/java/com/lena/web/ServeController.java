package com.lena.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServeController {


   //欢迎页
    @GetMapping("/")
    public String index() {
        return "home";
    }

    // 登陆页
    @GetMapping("/userlogin")
    public String loginPage() {
        return "login";
    }



}

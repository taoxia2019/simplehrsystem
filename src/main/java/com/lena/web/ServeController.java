package com.lena.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServeController {


   //欢迎页
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 登陆页
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username,String password) {
        System.out.println(username);

        return "login";
    }


}

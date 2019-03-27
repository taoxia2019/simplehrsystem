package com.lena.web;


import com.lena.entity.TUser;

import com.lena.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
public class TUserController {
    @Autowired
    ITUserService itUserService;

    @RequestMapping("/login")
    public String login(String username,String password){

        System.out.println(username);
        return "index";
    }

    @RequestMapping("/registpage")
    public String toRegist(){
        return "users/regist";
    }

    @RequestMapping("/regist")
    public String regist(TUser tUser){
        tUser.setSysUserPwd(new BCryptPasswordEncoder().encode(tUser.getSysUserPwd()));
        itUserService.insert(tUser);
        return "/login";

    }
}


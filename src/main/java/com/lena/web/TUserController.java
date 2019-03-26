package com.lena.web;


import com.lena.entity.TUser;

import com.lena.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/tUser")
public class TUserController {
    @Autowired
    ITUserService itUserService;

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


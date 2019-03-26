package com.lena.securityservice;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lena.entity.TRole;
import com.lena.entity.TUser;
import com.lena.mapper.TRoleMapper;
import com.lena.mapper.TUserMapper;
import com.lena.mapper.TUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过用户名查询是否有这个对象
       TUser tUser=tUserMapper.selectByName(username);
       //通过用户名查询所有角色
        List<TRole> tRoles = tUserMapper.findRoleByTUserId(tUser.getId());
        //将role导入到权限当中
        List<GrantedAuthority> authorities=new ArrayList<>();
        for (TRole role:tRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(tUser.getSysUserName(),tUser.getSysUserPwd(),authorities);
    }
}

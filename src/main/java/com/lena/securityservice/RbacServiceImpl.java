package com.lena.securityservice;

import com.lena.entity.TPermission;
import com.lena.entity.TUser;
import com.lena.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacServiceImpl")
public class RbacServiceImpl implements RbacService {
    @Autowired
    private TUserMapper tUserMapper;


    //用于匹配路径，因为路径中可能含有/**等，不能用equals
    public AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object principal=authentication.getPrincipal();
        boolean hasPermission=false;
        //如果是 匿名用户anonymousUser直接跳过下面的判断，返回false
        if(principal instanceof UserDetails){
            String username=((UserDetails)principal).getUsername();
            TUser tUser = tUserMapper.selectByName(username);
            //这里的permission是从数据库中查出来。
            List<TPermission> permissions = tUserMapper.findPermissionByUserId(tUser.getId());

            for (TPermission permission:permissions) {
                //比对数据库 url和请求中的requesturl
                if(antPathMatcher.match(permission.getUrl(),request.getRequestURI())){
                    hasPermission=true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}

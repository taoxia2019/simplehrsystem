package com.lena.config;

import com.lena.securityservice.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
1、导入依赖
2、创建Mysecurityconfig类，继承WebSecurityconfigurerAdapter
3、重写configuer方法
4、定制授权规则
页面导入名称空间，使用sec标签
xmlns:th="http://www.thymeleaf.org"
	  xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4"
 */
@EnableWebSecurity
public class MySecurityconfig extends WebSecurityConfigurerAdapter{
   /*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    //认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中放入三个用户，以及其密码，角色
  /*      auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("P","IP")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("IP","VIP")
                .and()
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("P","VIP");*/
        //通过myUserDetailsService认证用户是否具有权限
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //设置对应资源的访问权限(角色)
        http.authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/","/tUser/regist","/tUser/registpage").permitAll()
                .antMatchers("/userlogin").permitAll();
              /*  .antMatchers("/level1/**").hasRole("P")
                .antMatchers("/level2/**").hasRole("IP")
                .antMatchers("/level3/**").hasRole("VIP");*/
                //.antMatchers("/","/welcome","/logout","/userlogin","/login").permitAll();
        // access返回 TRUE 匹配成功，获得权限
      /* http.authorizeRequests().anyRequest().access("@rbacServiceImpl.hasPermission(request,authentication)");*/
        //开启登录功能
        http.formLogin().loginPage("/userlogin");

        //1./login到登录页( 默认的登录页)
       // 2定制登录页面的方法loginPage("/userlogin")方法中的参数（""）中填写指定的页面
        //2.登录错误重定向到错误页面
        //修改form中的name属性 usernameParameter("user")，.passwordParameter("pwd")
        //1.注销
        //2.注销后到定制页面
        //3、定制退出后的页面方法logoutSuccessUrl("/")方法中的参数（""）中填写指定的页面
        http.logout().logoutSuccessUrl("/").permitAll();
        //开启免登陆功能，记住我。登录成功后，将cookies 发给浏览器，以后访问就  带上这个cookies。点击注销后，删除 cookies
        //修改修改form中的name属性，rememberMeParameter("rememberMe")
        http.rememberMe().rememberMeParameter("rememberMe");
    }
}

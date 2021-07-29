package com.chen.blog.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 15:52
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //密码的加密策略
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        //加密策略 MD5 不安全 彩虹表 MD5加密
        String mszlu = new BCryptPasswordEncoder().encode("mszlu");
        System.out.println(mszlu);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//开启登录认证
                //.antMatchers("/user/findAll").hasRole("admin")//访问接口需要admin角色
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
                .antMatchers("/admin/**").access("@authService.auth(request,authentication)")//自定义service来去实现实时的权限认证
                .antMatchers("/pages/**").authenticated()
                .and().formLogin()
                .loginPage("/login.html")//自定义的登录页面
                .loginProcessingUrl("/login")//登录处理接口
                .usernameParameter("username")//定义登录时的用户名的key默认为username
                .passwordParameter("password")//定义登陆时的密码key，默认是password
                .defaultSuccessUrl("/pages/main.html")//登录成功后默认跳转到main.html
                .failureUrl("/login.html")//登录失败后跳转到login.html
                .permitAll()//通过 不拦截，这是指和登录表单相关的接口！都通过
                .and().logout()//退出登录配置
                .logoutUrl("/logout")//退出登录接口
                .logoutSuccessUrl("/login.html")
                .permitAll()//退出登录的接口放行
                .and()
                .httpBasic()//对http请求进行拦截
                .and()
                .csrf().disable()//csrf关闭 如果自定义登录 需要关闭
                .headers().frameOptions().sameOrigin();//支持iframe页面嵌套
    }
}

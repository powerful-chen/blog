package com.chen.blog.controller;

import com.chen.blog.service.LoginService;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 10:45
 */
@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){

        //sso单点登录，后期如果把登陆注册功能踢出去（单独的服务，可以独立提供接口服务）
        return loginService.register(loginParam);
    }
}

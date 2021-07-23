package com.chen.blog.service;

import com.chen.blog.dao.pojo.SysUser;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.LoginParam;

public interface LoginService {
    //登录功能
    Result login(LoginParam loginParam);

    //检验token是否存在
    SysUser checkToken(String token);

    //登录退出功能
    Result logout(String token);
}

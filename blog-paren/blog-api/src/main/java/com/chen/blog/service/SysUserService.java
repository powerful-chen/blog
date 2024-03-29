package com.chen.blog.service;

import com.chen.blog.dao.pojo.SysUser;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.UserVo;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 22:07
 */
public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long userId);

    SysUser findUser(String account, String password);

    //根据token查询用户信息
    Result findUserByToken(String token);

    //根据账号查找用户
    SysUser findUserByAccount(String account);

    //保持用户
    void save(SysUser sysUser);
}

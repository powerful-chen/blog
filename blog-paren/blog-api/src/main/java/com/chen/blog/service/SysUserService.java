package com.chen.blog.service;

import com.chen.blog.dao.pojo.SysUser;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 22:07
 */
public interface SysUserService {

    SysUser findUserById(Long userId);

}

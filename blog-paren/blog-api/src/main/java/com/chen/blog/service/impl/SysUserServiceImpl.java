package com.chen.blog.service.impl;

import com.chen.blog.dao.mapper.SysUserMapper;
import com.chen.blog.dao.pojo.SysUser;
import com.chen.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 22:10
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long userId) {
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("小陈之路");
        }
        return sysUser;
    }
}

package com.chen.blog.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.blog.admin.mapper.AdminMapper;
import com.chen.blog.admin.pojo.Admin;
import com.chen.blog.admin.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 17:00
 */
@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminByUsername(String username) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, username);
        queryWrapper.last("limit 1");
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    public List<Permission> findPermissionByAdminId(Long adminId) {
        return adminMapper.findPermissionByAdminId(adminId);
    }
}

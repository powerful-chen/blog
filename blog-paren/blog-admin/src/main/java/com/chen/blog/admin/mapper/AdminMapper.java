package com.chen.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.blog.admin.pojo.Admin;
import com.chen.blog.admin.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {

    @Select("SELECT * FROM ms_permission WHERE id in (SELECT permission_id from ms_admin_permission WHERE admin_id =#{adminId})")
    List<Permission> findPermissionByAdminId(Long adminId);
}

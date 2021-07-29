package com.chen.blog.admin.service;

import com.chen.blog.admin.pojo.Admin;
import com.chen.blog.admin.pojo.Permission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Slf4j
public class AuthService {

    @Autowired
    private AdminService adminService;

    public boolean auth(HttpServletRequest request, Authentication authentication) {
        //权限认证
        //请求路径
        String requestURI = request.getRequestURI();
        log.info("request url:{}", requestURI);
        //true代表放行 false 代表拦截
        //获取当前用户
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)) {
            //未登录
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;
        String username = userDetails.getUsername();
        Admin admin = adminService.findAdminByUsername(username);
        if (admin == null) {
            return false;
        }
        if (1 == admin.getId()) {
            //超级管理员
            return true;
        }
        Long id = admin.getId();
        List<Permission> permissionList = this.adminService.findPermissionByAdminId(id);
        //取不带参数的一部分
        requestURI = StringUtils.split(requestURI, "?")[0];
        for (Permission permission : permissionList) {
            if (requestURI.equals(permission.getPath())) {
                log.info("权限通过");
                return true;
            }
        }
        return false;
    }
}

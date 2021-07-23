package com.chen.blog.utils;

import com.chen.blog.dao.pojo.SysUser;

/**
 * @ClassName UserThreadLocal
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 15:56
 */
public class UserThreadLocal {

    private UserThreadLocal() {
    }

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser) {
        LOCAL.set(sysUser);
    }

    public static SysUser get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }

}

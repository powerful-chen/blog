package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:07
 */
@Data
public class SysUser {

    private Long id;

    private String account;

    private Integer admin;

    private String avatar;//头像

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;//最后登录时间

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;//加密盐

    private String status;//状态


}

package com.chen.blog.vo;

import lombok.Data;

/**
 * @ClassName LoginUserVo
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 8:52
 */
@Data
public class LoginUserVo {

    private Long id;

    private String account;

    private String nickname;

    private String avatar;
}

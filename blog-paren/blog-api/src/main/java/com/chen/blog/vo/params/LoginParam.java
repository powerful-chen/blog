package com.chen.blog.vo.params;

import lombok.Data;

/**
 * @ClassName LoginParam
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/22 15:00
 */
@Data
public class LoginParam {

    private String account;
    private String password;
    private String nickname;
}

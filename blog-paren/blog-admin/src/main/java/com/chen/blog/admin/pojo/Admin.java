package com.chen.blog.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 16:58
 */
@Data
public class Admin {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;
    
    private String password;
}

package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName Category
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 16:28
 */
@Data
public class Category {

    private Long id;

    private String avatar;

    private String categoryName;

    private String description;
}

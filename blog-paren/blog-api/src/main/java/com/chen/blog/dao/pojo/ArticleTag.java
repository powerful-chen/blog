package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName ArticleTag
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/25 10:34
 */
@Data
public class ArticleTag {

    private Long id;

    private Long articleId;

    private Long tagId;
}

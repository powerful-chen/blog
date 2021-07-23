package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName ArticleBody
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 16:26
 */
@Data
public class ArticleBody {

    private Long id;

    private String content;

    private String contentHtml;

    private Long articleId;
}

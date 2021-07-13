package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName Article
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 20:50
 */
@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;

    private String title;

    private String summary;//简介

    private int commentCounts;//评论数量

    private int viewCounts;//浏览数量

    private Long authorId;//作者id

    private Long bodyId;//内容id

    private Long categoryId;//类别id

    private int weight = Article_Common;//置顶

    private Long createDate;//创建时间

}

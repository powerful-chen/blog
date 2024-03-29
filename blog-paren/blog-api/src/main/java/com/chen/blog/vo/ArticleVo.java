package com.chen.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ArticleVo
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:29
 */
@Data
public class ArticleVo {

    private String id;

    private String title;

    private String summary;//简介

    private Integer commentCounts;//评论数量

    private Integer viewCounts;//浏览数量

    private Integer weight;//置顶

    private String createDate;//创建时间

    private String author;//作者

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private CategoryVo category;


}

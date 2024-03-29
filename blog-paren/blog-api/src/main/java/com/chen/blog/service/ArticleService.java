package com.chen.blog.service;

import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.ArticleParam;
import com.chen.blog.vo.params.PageParams;

public interface ArticleService {

    //分页查询 文章列表
    Result listArticle(PageParams pageParams);

    //最热文章
    Result hotArticle(int limit);

    //最新文章
    Result newArticles(int limit);

    //文章归档
    Result listArchives();

    //查看文章详情
    Result findArticleById(Long articleId);

    //文章发布
    Result publish(ArticleParam articleParam);
}

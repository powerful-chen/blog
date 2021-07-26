package com.chen.blog.controller;

import com.chen.blog.common.aop.LogAnnotation;
import com.chen.blog.common.cache.Cache;
import com.chen.blog.service.ArticleService;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.ArticleParam;
import com.chen.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/13 12:13
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //首页文章列表
    @PostMapping
    //加上此注解 代表要对此接口记录日志
    @LogAnnotation(module = "文章", operator = "获取文章列表")
    @Cache(expire = 5 * 60 * 1000, name = "listArticle")
    public Result articles(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    //最热文章
    @PostMapping("/hot")
    @Cache(expire = 5 * 60 * 1000, name = "hot_article")
    public Result hotArticles() {
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    //最新文章
    @PostMapping("/new")
    @Cache(expire = 5 * 60 * 1000, name = "new_articles")
    public Result newArticles() {
        int limit = 5;
        return articleService.newArticles(limit);
    }

    //文章归档
    @PostMapping("/listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    //查看文章详情
    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    //文章发布
    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }
}

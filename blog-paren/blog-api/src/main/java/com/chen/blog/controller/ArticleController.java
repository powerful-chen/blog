package com.chen.blog.controller;

import com.chen.blog.service.ArticleService;
import com.chen.blog.vo.Result;
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
    public Result articles(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

}

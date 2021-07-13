package com.chen.blog.service;

import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.PageParams;

public interface ArticleService {

    //分页查询 文章列表
    Result listArticle(PageParams pageParams);

}

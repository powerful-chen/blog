package com.chen.blog.service;

import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.CommentParam;

public interface CommentService {

    //根据文章id查询所有的评论列表
    Result commentsByArticleId(Long id);

    //评论文章
    Result comment(CommentParam commentParam);
}

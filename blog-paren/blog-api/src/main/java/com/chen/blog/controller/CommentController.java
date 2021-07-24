package com.chen.blog.controller;

import com.chen.blog.service.CommentService;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.params.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/24 8:58
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/article/{id}")
    public Result comments(@PathVariable("id") Long id){
        return commentService.commentsByArticleId(id);
    }

    @PostMapping("/create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentService.comment(commentParam);
    }
}

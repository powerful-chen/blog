package com.chen.blog.controller;

import com.chen.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 15:35
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    public Result test() {
        return Result.success(null);
    }
}

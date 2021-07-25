package com.chen.blog.controller;

import com.chen.blog.service.CategoryService;
import com.chen.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/25 8:39
 */
@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result categories(){
        return categoryService.findAll();
    }
}

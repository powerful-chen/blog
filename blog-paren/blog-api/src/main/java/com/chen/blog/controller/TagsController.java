package com.chen.blog.controller;

import com.chen.blog.service.TagsService;
import com.chen.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TagsController
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/13 15:32
 */
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    //最热标签
    @GetMapping("/hot")
    public Result hot() {
        int limit = 6;
        return tagsService.hots(limit);
    }

    //查找所有标签
    @GetMapping()
    public Result findAll() {
        return tagsService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail() {
        return tagsService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id) {
        return tagsService.findDetailById(id);
    }

}

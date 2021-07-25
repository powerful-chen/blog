package com.chen.blog.service;

import com.chen.blog.vo.Result;
import com.chen.blog.vo.TagVo;

import java.util.List;

/**
 * @ClassName TagsService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 22:14
 */
public interface TagsService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    //查找所有文章
    Result findAll();

    Result findAllDetail();

    Result findDetailById(Long id);
}

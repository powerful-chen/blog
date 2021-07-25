package com.chen.blog.service;

import com.chen.blog.vo.CategoryVo;
import com.chen.blog.vo.Result;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 17:03
 */
public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    //通过id查询分类列表
    Result categoryDetailById(Long id);
}

package com.chen.blog.service;

import com.chen.blog.vo.CategoryVo;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 17:03
 */
public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);
}

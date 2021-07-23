package com.chen.blog.service.impl;

import com.chen.blog.dao.mapper.CategoryMapper;
import com.chen.blog.dao.pojo.Category;
import com.chen.blog.service.CategoryService;
import com.chen.blog.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/23 17:03
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}

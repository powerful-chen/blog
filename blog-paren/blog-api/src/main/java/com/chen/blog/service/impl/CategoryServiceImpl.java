package com.chen.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.blog.dao.mapper.CategoryMapper;
import com.chen.blog.dao.pojo.Category;
import com.chen.blog.service.CategoryService;
import com.chen.blog.vo.CategoryVo;
import com.chen.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    @Override
    public Result findAll() {
        List<Category> categories = categoryMapper.selectList(new LambdaQueryWrapper<>());
        //页面交互对象
        return Result.success(copyList(categories));
    }

    public CategoryVo copy(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    public List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }

}

package com.chen.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.blog.dao.pojo.Tag;

import java.util.List;

/**
 * @ClassName TagMapper
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:26
 */
public interface TagMapper extends BaseMapper<Tag> {
    //根据文章id查询标签列表
    List<Tag> findTagsByArticleId(Long articleId);
}

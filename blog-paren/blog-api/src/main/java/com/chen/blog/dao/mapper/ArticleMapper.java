package com.chen.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.blog.dao.dos.Archives;
import com.chen.blog.dao.pojo.Article;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:25
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}

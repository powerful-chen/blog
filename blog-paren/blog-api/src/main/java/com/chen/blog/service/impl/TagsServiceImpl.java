package com.chen.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chen.blog.dao.mapper.TagMapper;
import com.chen.blog.dao.pojo.Tag;
import com.chen.blog.service.TagsService;
import com.chen.blog.vo.Result;
import com.chen.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName TagsServiceImpl
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 22:15
 */
@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagMapper tagMapper;

    //拷贝将tag的属性copy到tagVo中
    public TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    //将tagList转化为相应的Vo
    public List<TagVo> copyList(List<Tag> tagList) {
        ArrayList<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    //最热标签
    @Override
    public Result hots(int limit) {
        /**
         * 思路：
         * 1、标签所拥有的文章数量最多 最热标签
         * 2、查询 根据tag_id 分组计数，从大到小 排列取前limit个
         */
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        //如果tagIds为空则将其设为空数组
        if (CollectionUtils.isEmpty(tagIds)) {
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);

        return Result.success(tagList);
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId, Tag::getTagName);
        List<Tag> tags = this.tagMapper.selectList(queryWrapper);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findAllDetail() {
        List<Tag> tags = this.tagMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(tags));
    }

    @Override
    public Result findDetailById(Long id) {
        Tag tag = this.tagMapper.selectById(id);
        return Result.success(copy(tag));
    }
}

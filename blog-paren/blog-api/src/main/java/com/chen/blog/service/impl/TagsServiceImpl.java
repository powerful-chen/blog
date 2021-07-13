package com.chen.blog.service.impl;

import com.chen.blog.dao.mapper.TagMapper;
import com.chen.blog.dao.pojo.Tag;
import com.chen.blog.service.TagsService;
import com.chen.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}

package com.chen.blog.vo.params;

import com.chen.blog.vo.CategoryVo;
import com.chen.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ArticleParam
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/25 10:17
 */
@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}

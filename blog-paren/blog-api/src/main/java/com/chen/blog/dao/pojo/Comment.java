package com.chen.blog.dao.pojo;

import lombok.Data;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/24 8:50
 */
@Data
public class Comment {

    private Long id;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Long toUid;

    private Integer level;
}

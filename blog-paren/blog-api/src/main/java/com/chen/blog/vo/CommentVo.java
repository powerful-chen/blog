package com.chen.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName CommentVo
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/24 9:16
 */
@Data
public class CommentVo {

    private Long id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;


}

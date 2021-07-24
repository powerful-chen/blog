package com.chen.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    //防止前端精度损失 把id转为string
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private UserVo author;

    private String content;

    private List<CommentVo> childrens;

    private String createDate;

    private Integer level;

    private UserVo toUser;


}

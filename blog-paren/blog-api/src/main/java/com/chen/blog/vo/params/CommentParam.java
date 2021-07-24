package com.chen.blog.vo.params;

import lombok.Data;

/**
 * @ClassName CommentParam
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/24 16:30
 */
@Data
public class CommentParam {

    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}

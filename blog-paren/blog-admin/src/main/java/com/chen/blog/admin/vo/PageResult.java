package com.chen.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 10:37
 */
@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;
}

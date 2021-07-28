package com.chen.blog.admin.model.params;

import lombok.Data;

/**
 * @ClassName PageParam
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 10:20
 */
@Data
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;
}

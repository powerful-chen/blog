package com.chen.blog.vo.params;

import lombok.Data;

/**
 * @ClassName PageParams
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:48
 */
@Data
//页面默认参数
public class PageParams {

    private int page = 1;

    private int pageSize = 10;

    private Long categoryId;

    private Long tagId;

}

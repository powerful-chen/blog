package com.chen.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 21:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//统一返回结果
public class Result {

    private boolean success;

    private Integer code;

    private String msg;

    private Object data;

    //成功时
    public static Result success(Object data) {
        return new Result(true, 200, "success", data);
    }

    //失败时
    public static Result fail(Integer code, String msg) {
        return new Result(false, code, msg, null);
    }

}

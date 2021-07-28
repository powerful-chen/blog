package com.chen.blog.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Result
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/28 10:24
 */
@Data
@AllArgsConstructor
public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

    public static Result success(Object data) {
        return new Result(true, 200, "success", data);
    }

    public static Result fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }

}

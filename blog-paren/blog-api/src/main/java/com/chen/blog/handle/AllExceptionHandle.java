package com.chen.blog.handle;

import com.chen.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AllExceptionHandle
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/13 16:57
 */
//对加了@Controller注解的方法进行拦截处理，它是AOP的实现
@ControllerAdvice
public class AllExceptionHandle {
    //进行异常处理，处理Exception.class的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return Result.fail(-999, "系统异常");
    }
}

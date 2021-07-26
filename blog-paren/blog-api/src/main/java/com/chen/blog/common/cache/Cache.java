package com.chen.blog.common.cache;

import java.lang.annotation.*;

/**
 * @ClassName Cache
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/26 14:55
 */
//缓存
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    //设置默认过期时间
    long expire() default 1 * 50 * 1000;

    //缓存标识 key
    String name() default "";
}
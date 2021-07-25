package com.chen.blog.common.aop;

import java.lang.annotation.*;

//TYPE 代表可以放在类上 METHOD代表可以再方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operator() default "";
}

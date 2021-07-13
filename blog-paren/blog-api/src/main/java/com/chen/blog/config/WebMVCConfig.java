package com.chen.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMVCConfig
 * @Description TODO
 * @Author xiaochen
 * @Date 2021/7/12 19:33
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    //跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }
}

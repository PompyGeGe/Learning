package com.learning.spring.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 皮皮
 * @Date: 2024/8/2 21:09
 * @Description:
 * 【利用WebMvcConfigurer将拦截器添加到拦截器链里！】
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyFirstInterceptor myFirstInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myFirstInterceptor)
                .addPathPatterns("/**") // 拦截所有请求路径
                .excludePathPatterns("/static/**", "/error", "/webjars/**"); // 排除不需要拦截的路径
    }
}
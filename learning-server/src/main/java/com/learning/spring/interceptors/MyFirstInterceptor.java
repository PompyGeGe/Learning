package com.learning.spring.interceptors;

import com.learning.spring.beanRegister.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 皮皮
 * @Date: 2024/8/2 19:56
 * @Description:
 */
@Component
@Order(1) // 优先级为1，数值越小，优先级越高
@Slf4j
public class MyFirstInterceptor implements HandlerInterceptor {

    @Autowired
    private StudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println(studentService.getClass());

        log.info("this is MyFirstInterceptor's preHandle!");

        //如果这里return false，则后面的controller的方法、次拦截器的postHandle和afterCompletion都不会执行了！
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        log.info("this is MyFirstInterceptor's postHandle!");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        log.info("this is MyFirstInterceptor's afterCompletion!");
    }

}


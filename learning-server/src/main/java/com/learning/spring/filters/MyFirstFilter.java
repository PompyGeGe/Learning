package com.learning.spring.filters;

import com.learning.spring.beanRegister.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 皮皮
 * @Date: 2024/8/3 22:57
 * @Description:
 */
@Component
@Slf4j
//在Springboot项目中，可以直接用@Component的方式将Filter注入，而无需使用@WebFilter，此时匹配的路径默认为/*
public class MyFirstFilter implements Filter {

    @Autowired
    private StudentService studentService;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("this is MyFirstFilter's doFilter before");

        System.out.println("hahahah"+studentService.getClass());

        chain.doFilter(request, response);

        log.info("this is MyFirstFilter's doFilter after");
    }

}
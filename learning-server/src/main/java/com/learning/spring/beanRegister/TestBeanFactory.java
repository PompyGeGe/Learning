package com.learning.spring.beanRegister;

import com.learning.spring.interceptors.MyFirstInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/7/1 14:36
 * @Description:
 */
@Service
public class TestBeanFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private final StudentService studentService;


    public Object getClass(String className) {
        studentService.getClass();
        MyFirstInterceptor myFirstInterceptor = (MyFirstInterceptor) applicationContext.getBean("myFirstInterceptor");
        return applicationContext.getBean(className);
    }

    public TestBeanFactory(StudentService studentService){
        this.studentService = studentService;
        System.out.println("实例化");
    }


}

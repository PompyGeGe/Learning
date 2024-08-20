package com.learning.spring.beanRegister;

import com.learning.spring.interceptors.MyFirstInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/7/3 15:48
 * @Description:
 */
@Service
public class Test {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Test testBean = (Test) context.getBean("test");

    }
}

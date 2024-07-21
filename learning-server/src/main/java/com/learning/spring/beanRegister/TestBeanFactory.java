package com.learning.spring.beanRegister;

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

    @Autowired
    StudentService studentService;


    public Object getClass(String className) {
        return applicationContext.getBean(className);
    }

}

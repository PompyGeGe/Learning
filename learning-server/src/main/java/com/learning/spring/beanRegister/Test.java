package com.learning.spring.beanRegister;

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

        //测试studentService注入进来了
        System.out.println(testBean.studentService);

        //测试applicationContext注入进来了
        System.out.println(testBean.applicationContext);

        //！！！用这种方式无法注入studentService和applicationContext，因为是自己new的bean，
        //没有交给spring管理，里面的service注入不进去
        System.out.println(new Test().studentService);
        System.out.println(new Test().applicationContext);
    }
}

package com.learning.spring.beanRegister;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 皮皮
 * @Date: 2024/7/3 15:48
 * @Description:
 */
@Configuration
@ComponentScan("com.com.learning.*")
public class MyConfig {

    /*@Bean
    public StudentService studentService1() {
        return new StudentService();
    }*/


}

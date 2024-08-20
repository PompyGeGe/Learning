package com.learning.spring.beanRegister;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/7/3 16:21
 * @Description:
 */
@Service("studentService2")
public class StudentService{

    @Value("${spring.profiles.active}")
    private String a;

}

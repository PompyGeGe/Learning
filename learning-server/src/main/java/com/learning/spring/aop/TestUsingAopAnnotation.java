package com.learning.spring.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 皮皮
 * @Date: 2024/8/7 14:08
 * @Description:
 */
@Service
public class TestUsingAopAnnotation {


    //测试这个注解是否有用到AOP，用了AOP就会有代理对象，这可以在bean的生命周期的BeanPostProcessor接口实现类AbstractAutoProxyCreator-postProcessAfterInitialization方法里打断点看到
    @Transactional
    public void print(){

    }
}

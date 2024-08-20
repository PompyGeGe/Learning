package com.learning.spring.beanLifeCycle.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/8/4 23:57
 * @Description:
 */
@Service
@Slf4j
public class TestAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.info("ApplicationContextAware接口的实现类的调用！");
    }
}

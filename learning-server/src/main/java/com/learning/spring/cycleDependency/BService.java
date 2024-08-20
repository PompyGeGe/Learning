package com.learning.spring.cycleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/8/6 22:22
 * @Description:
 */
@Service
@Lazy//用了@Lazy后，连构造方法的注入造成的循环依赖都可以被解决了，嘻嘻
public class BService {

    private final AService aService;

    @Autowired
    public BService(AService aService) {
        this.aService = aService;
    }
}
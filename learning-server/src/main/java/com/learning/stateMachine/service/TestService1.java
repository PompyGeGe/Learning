package com.learning.stateMachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: 皮皮
 * @Date: 2024/6/30 14:34
 * @Description:
 */
@Slf4j
@Service
public class TestService1 implements Action, Condition {
    @Override
    public void execute(Object from, Object to, Object event, Object context) {
        log.info("实现类TestService1开始执行");
    }

    @Override
    public boolean isSatisfied(Object context) {
        log.info("实现类TestService1的条件满足");
        return true;
    }
}

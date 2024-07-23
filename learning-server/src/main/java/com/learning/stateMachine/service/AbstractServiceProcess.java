package com.learning.stateMachine.service;

import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.learning.stateMachine.context.Context;
import com.learning.stateMachine.enums.AfterSaleEvent;
import com.learning.stateMachine.enums.AfterSaleStageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@Slf4j
public abstract class AbstractServiceProcess implements ServiceProcess {
    @Resource
    private ApplicationContext applicationContext;
    /**
     * Check Condition
     * @param context
     * @return
     */
    protected abstract boolean doCheckCondition(Context context);

    /**
     * core process
     * @param from
     * @param to
     * @param event
     * @param context
     */
    public abstract void action(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context);


    public Condition<Context> checkCondition(){
        return (ctx) -> {
            return doCheckCondition(ctx);
        };
    }

    public Action<AfterSaleStageEnum, AfterSaleEvent, Context> doAction() {
        return (from, to, event, context) -> {
            this.before(from, to, event, context);
            this.action(from, to, event, context);
            this.after(from, to, event, context);
            System.out.println("当前执行"+this.getClass().getName());
        };
    }

    @Override
    public void before(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context) {

    }

    @Override
    public void after(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context) {

    }
}

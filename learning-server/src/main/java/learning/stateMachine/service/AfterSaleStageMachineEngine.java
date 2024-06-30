package learning.stateMachine.service;

import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import learning.stateMachine.context.Context;
import learning.stateMachine.enums.AfterSaleEvent;
import learning.stateMachine.enums.AfterSaleStageEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class AfterSaleStageMachineEngine {
    public static final String AFTER_SALE_MACHINE_ID = "AFTER_SALE_STAGE_MACHINE";

    @Resource
    private AfterSaleStatusToCancelServiceProcess afterSaleStatusToCancelServiceProcess;

    @Resource
    private TestService1 testService1;

    @PostConstruct
    private void init() {
        StateMachineBuilder<AfterSaleStageEnum, AfterSaleEvent, Context> builder = StateMachineBuilderFactory.create();
       /* builder.externalTransitions()
                .fromAmong(AfterSaleStageEnum.WAIT_RECEIVE)
                .to(AfterSaleStageEnum.WAIT_DEAL)
                .on(AfterSaleEvent.RECEIPT_GOODS_WAIT_REFUND)
                .when(afterSaleStatusToCancelServiceProcess.checkCondition())
                .perform(afterSaleStatusToCancelServiceProcess.doAction());*/

        //自己用另一种方式，发现也可以。原来的好像很绕，实际上就是 传两个接口 就好了。
        builder.externalTransitions()
                .fromAmong(AfterSaleStageEnum.WAIT_RECEIVE)
                .to(AfterSaleStageEnum.WAIT_DEAL)
                .on(AfterSaleEvent.RECEIPT_GOODS_WAIT_REFUND)
                .when(testService1)
                .perform(testService1);

        builder.build(AFTER_SALE_MACHINE_ID);
    }

}

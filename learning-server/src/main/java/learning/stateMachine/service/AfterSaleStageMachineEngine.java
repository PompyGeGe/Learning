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

    @PostConstruct
    private void init() {
        StateMachineBuilder<AfterSaleStageEnum, AfterSaleEvent, Context> builder = StateMachineBuilderFactory.create();
        builder.externalTransitions()
                .fromAmong(AfterSaleStageEnum.WAIT_RECEIVE)
                .to(AfterSaleStageEnum.WAIT_DEAL)
                .on(AfterSaleEvent.RECEIPT_GOODS_WAIT_REFUND)
                .when(afterSaleStatusToCancelServiceProcess.checkCondition())
                .perform(afterSaleStatusToCancelServiceProcess.doAction());

        builder.build(AFTER_SALE_MACHINE_ID);
    }

}

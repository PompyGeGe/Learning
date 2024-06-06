package learning.stateMachine.service;

import learning.stateMachine.context.Context;
import learning.stateMachine.enums.AfterSaleEvent;
import learning.stateMachine.enums.AfterSaleStageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wuzhongshang
 * created  2024-02-27
 */
@Component
@Slf4j
public class AfterSaleStatusToCancelServiceProcess extends AbstractServiceProcess {

    @Override
    protected boolean doCheckCondition(Context context) {
        return true;
    }

    @Override
    public void action(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context) {
        log.info("AfterSaleStatusToCancelServiceProcess 的 action 执行");
    }

    @Override
    public void before(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context) {
        log.info("AfterSaleStatusToCancelServiceProcess 的 before 执行");
    }

    @Override
    public void after(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context) {
        log.info("AfterSaleStatusToCancelServiceProcess 的 after 执行");

    }

}

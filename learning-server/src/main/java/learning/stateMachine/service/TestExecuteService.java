package learning.stateMachine.service;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;
import com.alibaba.fastjson.JSON;
import controller.common.exception.BusinessErrorEnum;
import controller.common.exception.BusinessException;
import controller.dto.request.ReqDTO;
import learning.stateMachine.context.Context;
import learning.stateMachine.enums.AfterSaleEvent;
import learning.stateMachine.enums.AfterSaleStageEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Author: 皮皮
 * @Date: 2024/6/4 16:23
 * @Description:
 */
@Component
@Slf4j
public class TestExecuteService {

    public void execute(ReqDTO reqDTO) {

        Context context = new Context();

        AfterSaleEvent afterSaleEvent = AfterSaleEvent.RECEIPT_GOODS_WAIT_REFUND;

        StateMachine<AfterSaleStageEnum, AfterSaleEvent, Context> machine = StateMachineFactory.get(AfterSaleStageMachineEngine.AFTER_SALE_MACHINE_ID);
        AfterSaleStageEnum target = machine.fireEvent(AfterSaleStageEnum.getByCode(reqDTO.getAfterSaleStage()), afterSaleEvent, context);

        /**
         * 若原状态已不是此事件对应的原状态，则target的值为原状态; target也不是预料的状态，就会报错！
         */
        if (!AfterSaleStageEnum.WAIT_DEAL.equals(target)) {
            log.error("event:{},状态机结果不匹配:{}", afterSaleEvent, JSON.toJSONString(context));
            throw new BusinessException(BusinessErrorEnum.STATUS_MACHINE_ERROR);
        }

    }

}

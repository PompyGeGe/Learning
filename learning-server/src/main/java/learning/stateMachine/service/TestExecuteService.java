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
        //如果原状态不是配置的原状态，直接返回原状态
        AfterSaleStageEnum target = machine.fireEvent(AfterSaleStageEnum.getByCode(reqDTO.getAfterSaleStage()), afterSaleEvent, context);

        /**
         * 举例，下面两mq事件按顺序发生：
         *  1.支付事件：支付中->配送中
         *  2.配送完成事件：配送中->配送完成
         *  场景一：现在有这两个事件消息同时发过来，可以根据时间戳或者状态顺序 有序地去处理这两个消息，保证不出错。
         *  场景二：
         *        先收到事件2，发现当前状态仍是支付中，和事件2配置的原状态不一样，则返回支付中，会报错！则抛异常等待重试！
         *        过了几分钟，收到了事件1，发现状态是支付中，和事件1配置的原状态一样，则返回配送中，下面不会报错。
         *        而刚才异常的mq消息重试后，就可以正确运行了。
         */
        if (!AfterSaleStageEnum.WAIT_DEAL.equals(target)) {
            log.error("event:{},状态机结果不匹配:{}", afterSaleEvent, JSON.toJSONString(context));
            throw new BusinessException(BusinessErrorEnum.STATUS_MACHINE_ERROR);
        }

    }

}

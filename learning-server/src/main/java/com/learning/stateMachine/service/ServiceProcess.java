package com.learning.stateMachine.service;

import com.learning.stateMachine.context.Context;
import com.learning.stateMachine.enums.AfterSaleEvent;
import com.learning.stateMachine.enums.AfterSaleStageEnum;

public interface ServiceProcess {
    /**
     *  prefix process
     * @param from
     * @param to
     * @param event
     * @param context
     */
    void before(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context);

    /**
     * suffix process
     * @param from
     * @param to
     * @param event
     * @param context
     */
    void after(AfterSaleStageEnum from, AfterSaleStageEnum to, AfterSaleEvent event, Context context);
}

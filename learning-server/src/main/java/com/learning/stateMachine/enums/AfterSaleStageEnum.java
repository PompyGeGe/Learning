package com.learning.stateMachine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sunyue@qudian.com
 * created 2022/6/6 5:01 PM
 */
@Getter
@AllArgsConstructor
public enum AfterSaleStageEnum {
    /**
     * 售后状态
     */
    UNKNOWN(-1, "未知"),
    //WAIT_APPROVE(0, "待审批"),
    //REJECT(10, "审批驳回"),
    //APPROVE(20, "审批通过"),
    PROCESSING(35, "处理中"),
    WAIT_SEND(36, "待寄回"),
    WAIT_RECEIVE(37, "待收货"),
    WAIT_DEAL(38, "已收货待发起退款"),
    REFUNDING(39, "退款中"),
    DONE(40, "完成"),
    CANCEL(50, "取消"),
    ;

    private Integer code;
    private String desc;

    public static AfterSaleStageEnum getByCode(Integer code) {
        for (AfterSaleStageEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return UNKNOWN;
    }

    public Integer getCode() {
        return this.code;
    }

}

package learning.stateMachine.enums;

public enum AfterSaleEvent {
    //发起退款->退款中
    REFUNDING,
    //退款成功
    REFUND_SUCCESS,
    //关闭售后单
    CLOSE,
    //取消
    CANCEL,
    //审批驳回
    APPROVE_REJECT,
    //审批通过
    APPROVE_PASS,
    //用户填写物流信息
    FILL_OUT_EXPRESS_INFO,
    //(仓库收货)待退款
    RECEIPT_GOODS_WAIT_REFUND

    ;
}

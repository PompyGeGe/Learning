package controller.common.exception;

import lombok.Getter;

/**
 * @author qudian
 * @date 2022/1/18 5:21 下午
 */
public class BusinessException extends BaseException {
    @Getter
    private String i18n;

    public BusinessException(BusinessErrorEnum businessErrorEnum) {
        super(businessErrorEnum.code, businessErrorEnum.message, businessErrorEnum.displayable, businessErrorEnum.level);
        this.i18n = businessErrorEnum.getI18nKey();
    }

}

package controller.common.exception;

/**
 * 异常枚举
 * @author qudian
 */
public enum BusinessErrorEnum {
    SYSTEM_ERROR(500,"系统异常",false,BaseException.LevelEnum.ERROR, "system.error"),

    STATUS_MACHINE_ERROR(90001, "状态机流转异常", false, BaseException.LevelEnum.ERROR,"system.error"),
    ;


    public Integer code;

    public String message;

    /**
     * 是否用户可见 (true: 为产品确认可直接toast给用户提示的)
     */
    public Boolean displayable;

    public BaseException.LevelEnum level;

    public String i18nKey;

    public Integer getCode() {
        return code;
    }

    public String getI18nKey() {
        return i18nKey;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getDisplayable() {
        return displayable;
    }

    public BaseException.LevelEnum getLevel() {
        return level;
    }

    BusinessErrorEnum(Integer code, String message, Boolean displayable, BaseException.LevelEnum level, String i18nKey) {
        this.code = code;
        this.message = message;
        this.displayable = displayable;
        if (level == null) {
            level = BaseException.LevelEnum.ERROR;
        }
        this.level = level;
        this.i18nKey = i18nKey;
    }

    public static BusinessErrorEnum findByCode(Integer code){
        for (BusinessErrorEnum value : BusinessErrorEnum.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }

        return null;
    }

}

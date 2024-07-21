package com.controller.common.exception;

/**
 * @Author: 皮皮
 * @Date: 2024/6/4 16:18
 * @Description:
 */
public class BaseException  extends RuntimeException {
    private Integer code;
    private String message;
    private boolean displayable;
    private BaseException.LevelEnum level;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDisplayable() {
        return this.displayable;
    }

    public void setDisplayable(boolean displayable) {
        this.displayable = displayable;
    }

    public BaseException.LevelEnum getLevel() {
        return this.level;
    }

    public void setLevel(BaseException.LevelEnum level) {
        this.level = level;
    }

    public BaseException(Integer code, String message, Boolean displayable) {
        this.code = code;
        this.message = message;
        this.displayable = displayable;
        this.level = BaseException.LevelEnum.ERROR;
    }

    public BaseException(Integer code, String message, Boolean displayable, BaseException.LevelEnum level) {
        this.code = code;
        this.message = message;
        this.displayable = displayable;
        this.level = level;
    }

    public BaseException() {
    }

    public static enum LevelEnum {
        ERROR,
        WARNING,
        INFO,
        DEBUG;

        private LevelEnum() {
        }
    }
}


package controller.dto.response;

import java.io.Serializable;

/**
 * @Author: 皮皮
 * @Date: 2024/6/4 16:16
 * @Description:
 */
public class BaseResponseDTO <T> implements Serializable {
    public static final Integer SUCCESS_CODE = 0;
    private Integer code;
    private String message;
    private boolean displayable;
    private T data;

    public BaseResponseDTO() {
    }

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

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }

}

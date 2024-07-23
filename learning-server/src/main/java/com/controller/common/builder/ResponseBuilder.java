package com.controller.common.builder;

import com.controller.common.constant.BaseConstant;
import com.controller.common.exception.BaseException;
import com.controller.dto.response.BaseResponseDTO;

/**
 * @Author: 皮皮
 * @Date: 2024/6/4 16:26
 * @Description:
 */
public class ResponseBuilder {
    public ResponseBuilder() {
    }

    public static <T> BaseResponseDTO<T> buildError(BaseException baseException) {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(baseException.getCode());
        baseResponseDTO.setMessage(baseException.getMessage());
        baseResponseDTO.setDisplayable(baseException.isDisplayable());
        return baseResponseDTO;
    }

    public static <T> BaseResponseDTO<T> buildSuccess(T object) {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(BaseConstant.SUCCESS_CODE);
        baseResponseDTO.setMessage("SUCCESS");
        baseResponseDTO.setData(object);
        return baseResponseDTO;
    }

    public static <T> BaseResponseDTO<T> buildSystemError() {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(BaseConstant.SYSTEM_ERROR_CODE);
        baseResponseDTO.setMessage("system error");
        return baseResponseDTO;
    }

    public static <T> BaseResponseDTO<T> buildInvalidParameter(String message) {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(BaseConstant.INVALID_PARAMETER_CODE);
        baseResponseDTO.setMessage(message);
        return baseResponseDTO;
    }

}

package controller.common.constant;

/**
 * @Author: 皮皮
 * @Date: 2024/6/4 16:28
 * @Description:
 */
public class BaseConstant {
    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final Integer SYSTEM_ERROR_CODE = 500;
    public static final String SYSTEM_ERROR_MESSAGE = "system error";
    public static final Integer INVALID_PARAMETER_CODE = -1002;
    public static final String INVALID_PARAMETER_MESSAGE = "INVALID PARAMETER";
    public static final Integer NOT_OPERATOR_ID_CODE = -1003;
    public static final String NOT_OPERATOR_ID_MESSAGE = "operator id is null";
    public static final Integer NOT_OPERATOR_NAME_CODE = -1004;
    public static final String NOT_OPERATOR_NAME_MESSAGE = "operator name is null";
    public static final Integer NOT_STAFF_ID_CODE = -1005;
    public static final String NOT_STAFF_ID_MESSAGE = "staff id is null";
    public static final Integer NOT_PERMISSION_STATION = -1006;
    public static final String NOT_PERMISSION_STATION_MESSAGE = "permission station is null";
    public static final Integer NOT_DATA_PERMISSION = -1007;
    public static final String NOT_DATA_PERMISSION_MESSAGE = "not data permission";
    public static final Integer BUSINESS_CODE_FIELD_TYPE_ERROR = -1008;
    public static final String BUSINESS_CODE_FIELD_TYPE_ERROR_MESSAGE = "business code field type error";
    public static final Integer NOT_BUSINESS_CODE_VALUE = -1009;
    public static final String NOT_BUSINESS_CODE_VALUE_MESSAGE = "business code value is null";
    public static final Integer BUSINESS_CODE_NOT_SET_PERMISSION = -1010;
    public static final String BUSINESS_CODE_NOT_SET_PERMISSION_MESSAGE = "business code not set permission";

    public BaseConstant() {
    }
}
package com.clc.springboot.demo1.facade.enums.exception;

public enum ExceptionTypeEnum {

    //    程序异常
    UNKNOWN_EXCEPTION(-1, "系统内部错误"),
    LOGIN_ERROR(600, "用户未登陆，请重新登陆"),
    PARAM_EXCEPTION(601, "参数异常"),
    PARAM_NULL_EXCEPTION(602, "参数不可为空"),
    PARAM_NOT_EXISTS_EXCEPTION(603, "参数不存在"),
    SQL_EXCEPTION(604, "SQL异常,{0}"),
    SQL_FORMAT_EXCEPTION(605, "SQL语句出错，请检查SQL是否正确！{0}"),
    DATA_EXCEPTION(606, "数据异常"),
    JSON_EXCEPTION(608, "json异常"),
    JSON_PARSE_EXCEPTION(609, "json解析出错"),
    ONLY_SELECT_ALLOW(612, "只允许执行查询语句,请检查SQL语句！"),
    LOG_PARAM_ERROR(613, "日志记录参数错误"),
    USER_NOT_EXIST(614, "用户不存在"),
    ONLY_SUPPORT_SELECT(615, "仅支持查询语句"),
    TYPE_CAST_ERROR(616, "数据类型转换失败"),
    RSA_ENCRYPT_FAIL(617, "加密失败"),
    RSA_DECRYPT_FAIL(618, "解密失败"),
    VALIDATE_CODE_OUT_OF_DATE(619, "验证码已过期，请重新获取"),
    ;

    private Integer code;
    private String message;

    ExceptionTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

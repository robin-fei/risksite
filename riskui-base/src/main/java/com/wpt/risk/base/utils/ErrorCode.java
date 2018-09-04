package com.wpt.risk.base.utils;

public enum ErrorCode {
    SUCCESS(0, "成功"),
    PARAMETERS_ERROR(101, "参数错误"),
    QUERY_EVENT_ERROR(102, "查询事件列表失败"),
    USER_NOT_EXIST_ERROR(103, "用户不存在"),
    PASSWORD_ERROR(104, "密码错误"),
    RISK_EXCEPTION_ERROR(105, "业务异常"),
    SYS_ERROR(106, "系统错误"),
    BAD_CONTENT_TYPE(107, "Content-Type错误,请检查请求的Content-Type"),
    BAD_REQUEST(110, "参数缺失或错误"),
    API_NOT_FOUND(111, "API不存在,请检查URL和METHOD"),
    USED_EXCEPTION_ERROR(112, "业务数据使用中, 无法删除"),
    DUPLICATION_EXCEPTION_ERROR(113, "配置已存在, 无法新增"),;
    private final int error;
    private String errorMsg;

    ErrorCode(int error, String errorMsg) {
        this.error = error;
        this.errorMsg = errorMsg;
    }


    public ErrorCode errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getError() {
        return error;
    }
}
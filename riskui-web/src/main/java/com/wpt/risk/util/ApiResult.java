package com.wpt.risk.util;


import com.wpt.risk.base.utils.ErrorCode;

public class ApiResult<T> {

    private int code;
    private String message;
    private T result;

    public ApiResult(ErrorCode errorCode) {
        this.code = errorCode.getError();
        this.message = errorCode.getErrorMsg();
    }

    public ApiResult(ErrorCode errorCode, T result) {
        this.code = errorCode.getError();
        this.message = errorCode.getErrorMsg();
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
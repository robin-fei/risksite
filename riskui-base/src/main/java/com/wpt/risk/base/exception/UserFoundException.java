package com.wpt.risk.base.exception;

import com.wpt.risk.base.utils.ErrorCode;

public class UserFoundException extends Exception {

    private ErrorCode errorCode;

    public UserFoundException(String message) {
        super(message);
    }

    public UserFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public UserFoundException(ErrorCode errorCode, String message) {
        this(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
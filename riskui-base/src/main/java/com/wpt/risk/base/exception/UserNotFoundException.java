package com.wpt.risk.base.exception;

import com.wpt.risk.base.utils.ErrorCode;

public class UserNotFoundException extends Exception {

    private ErrorCode errorCode;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public UserNotFoundException(ErrorCode errorCode, String message) {
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
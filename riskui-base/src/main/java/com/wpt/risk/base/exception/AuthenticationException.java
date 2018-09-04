package com.wpt.risk.base.exception;

import com.wpt.risk.base.utils.ErrorCode;

public class AuthenticationException extends Exception {

    private ErrorCode errorCode;

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public AuthenticationException(ErrorCode errorCode, String message) {
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
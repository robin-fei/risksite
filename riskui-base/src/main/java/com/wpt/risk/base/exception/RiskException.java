package com.wpt.risk.base.exception;

public class RiskException extends Exception {

    public RiskException(String message) {
        super(message);
    }

    public RiskException(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.wpt.risk.base.exception;

public class RecordUsedException extends RuntimeException {

    public RecordUsedException() {
        super();
    }

    public RecordUsedException(String message) {
        super(message);
    }

    public RecordUsedException(String message, Throwable cause) {
        super(message, cause);
    }
}
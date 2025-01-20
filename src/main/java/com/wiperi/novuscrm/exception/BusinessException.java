package com.wiperi.novuscrm.exception;

public class BusinessException extends CustomException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Integer code) {
        super(message, code);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }
}

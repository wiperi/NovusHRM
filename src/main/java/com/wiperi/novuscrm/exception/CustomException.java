package com.wiperi.novuscrm.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    
    private final Integer code;
    private final String message;

    public CustomException(String message) {
        this(message, 400);
    }

    public CustomException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.code = 400;
    }

    public CustomException(String message, Integer code, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.code = code;
    }
} 
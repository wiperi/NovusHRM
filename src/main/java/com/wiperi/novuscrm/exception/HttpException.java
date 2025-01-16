package com.wiperi.novuscrm.exception;

public class HttpException extends CustomException {

    public HttpException(String message) {
        super(message);
    }

    public HttpException(String message, Integer code) {
        super(message, code);
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }
}

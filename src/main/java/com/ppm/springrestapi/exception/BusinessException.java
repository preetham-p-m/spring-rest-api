package com.ppm.springrestapi.exception;

import org.springframework.http.HttpStatus;

public class BusinessException {
    public final String message;
    public final Throwable throwable;
    public final HttpStatus httpStatus;

    public BusinessException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

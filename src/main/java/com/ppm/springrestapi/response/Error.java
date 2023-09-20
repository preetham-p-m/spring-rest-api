package com.ppm.springrestapi.response;

import org.springframework.http.HttpStatus;

public class Error {
    public final String message;
    public final Throwable throwable;
    public final HttpStatus httpStatus;

    public Error(String message, Throwable throwable, HttpStatus httpStatus) {
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

package com.ppm.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ppm.springrestapi.response.Error;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {

        Error businessException = new Error(notFoundException.getMessage(),
                notFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(businessException, HttpStatus.NOT_FOUND);
    }
}

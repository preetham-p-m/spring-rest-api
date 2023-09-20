package com.ppm.springrestapi.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static ResponseEntity<Object> build(String message, HttpStatus httpStatus, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", response);
        response.put("httpStatus", httpStatus);

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}

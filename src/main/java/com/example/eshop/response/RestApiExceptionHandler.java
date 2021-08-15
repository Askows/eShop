package com.example.eshop.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {RestApiException.class})
    public ResponseEntity<Object> handlerException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return  new ResponseEntity<>(e.getMessage(),status);

    }
}

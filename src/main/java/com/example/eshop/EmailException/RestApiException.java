package com.example.eshop.EmailException;

public class RestApiException extends RuntimeException{
    public RestApiException(String message) {
        super(message);
    }
}

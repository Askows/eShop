package com.example.eshop.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleBindingErrors(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getAllErrors()
                        .stream()
                        .map(e -> e.getDefaultMessage())
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler({NameException.class})
    public ResponseEntity handleNameException(NameException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}

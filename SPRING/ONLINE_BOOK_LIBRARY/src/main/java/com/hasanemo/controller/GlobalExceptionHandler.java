package com.hasanemo.controller;

import com.hasanemo.exception.AuthorNotFoundException;
import com.hasanemo.exception.BookIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookIdNotFoundException.class, AuthorNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception exception) {
        if (exception instanceof BookIdNotFoundException) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } else if (exception instanceof AuthorNotFoundException) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
    }

}

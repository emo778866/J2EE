package com.hasanemo.controller;

import com.hasanemo.exception.MangoNotFoundException;
import com.hasanemo.exception.SpriteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MangoNotFoundException.class, SpriteNotFoundException.class})
    public ResponseEntity<Object> returnNotFoundException(Exception exception) {
        if (validException(exception)) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

    private static boolean validException(Exception exception) {
        return exception instanceof MangoNotFoundException || exception instanceof SpriteNotFoundException;
    }

}

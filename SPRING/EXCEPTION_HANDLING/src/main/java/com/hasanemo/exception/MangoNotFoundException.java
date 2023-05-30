package com.hasanemo.exception;

public class MangoNotFoundException extends RuntimeException {
    public MangoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

package com.palekov.exceptions;

public class CreateException extends RuntimeException {

    public CreateException(String errorMessage) {
        super(errorMessage);
    }
}
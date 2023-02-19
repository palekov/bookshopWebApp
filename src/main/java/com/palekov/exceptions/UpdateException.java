package com.palekov.exceptions;

public class UpdateException extends RuntimeException {

    public UpdateException(String errorMessage) {
        super(errorMessage);
    }
}
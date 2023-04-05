package com.palekov.bookshop.exceptions;

public class UpdateException extends RuntimeException {

    public UpdateException(String errorMessage) {
        super(errorMessage);
    }
}
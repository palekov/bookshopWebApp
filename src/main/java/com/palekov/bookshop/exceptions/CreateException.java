package com.palekov.bookshop.exceptions;

public class CreateException extends RuntimeException {

    public CreateException(String errorMessage) {
        super(errorMessage);
    }
}
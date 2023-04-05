package com.palekov.bookshop.controller;

import com.palekov.bookshop.exceptions.CreateException;
import com.palekov.bookshop.exceptions.DeleteException;
import com.palekov.bookshop.exceptions.ExceptionResponse;
import com.palekov.bookshop.exceptions.InvalidInputParameterException;
import com.palekov.bookshop.exceptions.NotFoundException;
import com.palekov.bookshop.exceptions.UpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AbstractController {

    @ExceptionHandler(DeleteException.class)
    protected ResponseEntity<ExceptionResponse> handleDeleteException(DeleteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(CreateException.class)
    protected ResponseEntity<ExceptionResponse> handleCreateException(CreateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(UpdateException.class)
    protected ResponseEntity<ExceptionResponse> handleUpdateException(UpdateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(InvalidInputParameterException.class)
    protected ResponseEntity<ExceptionResponse> handleWrongParameterException(InvalidInputParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

}
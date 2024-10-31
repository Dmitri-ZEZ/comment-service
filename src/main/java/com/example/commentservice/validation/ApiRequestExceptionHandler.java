package com.example.commentservice.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handle(final RuntimeException exception) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponse(exception.getMessage(), LocalDateTime.now()));
    }
}

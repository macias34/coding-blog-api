package com.macias34.codingblogapi.api;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.macias34.codingblogapi.shared.exception.ApiException;
import com.macias34.codingblogapi.shared.exception.BadRequestException;
import com.macias34.codingblogapi.shared.response.ApiErrorResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ApiErrorResponse> handleApiException(ApiException e) {
        return ResponseEntity.status(e.getCode())
                .body(new ApiErrorResponse(
                        e.getMessage(),
                        e.getDescription(),
                        e.getCode()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BadRequestException handleConstraintViolationException(ConstraintViolationException e) {
        String message = "not valid due to validation error: " + e.getMessage();
        return new BadRequestException(message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiErrorResponse> handleAllUncaughtException(Exception exception) {
        ApiErrorResponse response = new ApiErrorResponse(
                "Internal Server Error",
                "An unexpected error occurred",
                HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
package com.macias34.codingblogapi.modules.user.domain.exception;

import org.springframework.http.HttpStatus;

import com.macias34.codingblogapi.shared.exception.ApiException;

public class UserNotFoundException extends ApiException {

    public UserNotFoundException() {
        super("User not found", null, HttpStatus.NOT_FOUND, null);
    }

    public UserNotFoundException(String description) {
        super("User not found", description, HttpStatus.NOT_FOUND, null);
    }
}

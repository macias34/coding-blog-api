package com.macias34.codingblogapi.modules.auth.domain.exception;

import org.springframework.http.HttpStatus;

import com.macias34.codingblogapi.shared.exception.ApiException;

public class WrongCredentialsException extends ApiException {

    public WrongCredentialsException() {
        super(" Wrong credentials", null, HttpStatus.UNAUTHORIZED, null);
    }

    public WrongCredentialsException(String description) {
        super("Wrong credentials", description, HttpStatus.UNAUTHORIZED, null);
    }
}

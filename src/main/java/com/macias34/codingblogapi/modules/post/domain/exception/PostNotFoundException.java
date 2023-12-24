package com.macias34.codingblogapi.modules.post.domain.exception;

import org.springframework.http.HttpStatus;

import com.macias34.codingblogapi.shared.exception.ApiException;

public class PostNotFoundException extends ApiException {

    public PostNotFoundException() {
        super("Post not found", null, HttpStatus.NOT_FOUND, null);
    }

    public PostNotFoundException(String description) {
        super("Post not found", description, HttpStatus.NOT_FOUND, null);
    }
}

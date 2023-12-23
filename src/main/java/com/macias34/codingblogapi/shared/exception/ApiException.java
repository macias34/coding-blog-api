package com.macias34.codingblogapi.shared.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException {

    private HttpStatus code;
    private String description;
    private String title;
    private Throwable cause;

    public ApiException(String title, String description, HttpStatus code) {
        super(title + (description != null ? (": " + description) : ""), null);
        this.code = code;
        this.title = title;
        this.description = description;
        this.cause = null;
    }

    public ApiException(String title, String description, HttpStatus code, Throwable cause) {
        super(title + (description != null ? (": " + description) : ""), cause);
        this.code = code;
        this.title = title;
        this.description = description;
        this.cause = cause;
    }
}
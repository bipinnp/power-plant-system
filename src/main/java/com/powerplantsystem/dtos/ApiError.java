package com.powerplantsystem.dtos;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors =  new ArrayList<>();

    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors.addAll(errors);
    }

    public ApiError(final HttpStatus status, final String message, final String error) {
        this.status = status;
        this.message = message;
        this.errors.add(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}

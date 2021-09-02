package com.example.taxserviceservlet.exception;

public class NoReportsFoundException extends RuntimeException {
    public NoReportsFoundException(String message) {
        super(message);
    }
}

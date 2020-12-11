package com.springboot.restapiwebservices.exception;

public class NoRecordFoundException extends Exception {
    private static final String NO_RECORD_FOUND = "No record found";
    public NoRecordFoundException() {
        super(NO_RECORD_FOUND);
    }

    public NoRecordFoundException(String message) {
        super(message);
    }
}

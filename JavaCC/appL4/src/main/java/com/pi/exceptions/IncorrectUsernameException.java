package com.pi.exceptions;

public class IncorrectUsernameException extends RuntimeException{
    public IncorrectUsernameException(String message) {
        super(message);
    }
}

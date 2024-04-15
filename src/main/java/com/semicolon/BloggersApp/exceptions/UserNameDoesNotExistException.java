package com.semicolon.BloggersApp.exceptions;

public class UserNameDoesNotExistException extends RuntimeException{
    public UserNameDoesNotExistException(String message){
        super(message);
    }
}

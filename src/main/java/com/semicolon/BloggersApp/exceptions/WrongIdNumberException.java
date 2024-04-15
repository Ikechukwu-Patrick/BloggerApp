package com.semicolon.BloggersApp.exceptions;

public class WrongIdNumberException extends RuntimeException{
    public WrongIdNumberException(String message){
        super(message);
    }
}

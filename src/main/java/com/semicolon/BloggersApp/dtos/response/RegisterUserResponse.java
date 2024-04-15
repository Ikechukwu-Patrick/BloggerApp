package com.semicolon.BloggersApp.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String id;
    private String userName;
    private String dateCreated;
    private String message;


}

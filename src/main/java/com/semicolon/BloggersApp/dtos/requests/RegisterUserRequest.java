package com.semicolon.BloggersApp.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
}

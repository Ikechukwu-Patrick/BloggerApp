package com.semicolon.BloggersApp.dtos.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String userName;
    private String passWord;
    private String message;
    private boolean isLocked;
}

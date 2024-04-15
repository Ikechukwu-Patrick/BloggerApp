package com.semicolon.BloggersApp.dtos.response;

import lombok.Data;

@Data
public class LoginUserResponse {
    private String id;
    private String userName;
    private String message;
}

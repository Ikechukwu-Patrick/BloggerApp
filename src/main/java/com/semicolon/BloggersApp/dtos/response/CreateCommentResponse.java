package com.semicolon.BloggersApp.dtos.response;

import lombok.Data;

@Data
public class CreateCommentResponse {
    private String id;
    private String date;
    private String message;

}

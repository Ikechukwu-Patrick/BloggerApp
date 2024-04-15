package com.semicolon.BloggersApp.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCommentRequest {
    private String comment;
    private String userName;
    private LocalDateTime localDateTime = LocalDateTime.now();
}

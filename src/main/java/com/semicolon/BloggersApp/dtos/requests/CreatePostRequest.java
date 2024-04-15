package com.semicolon.BloggersApp.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreatePostRequest {
    private String userName;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}

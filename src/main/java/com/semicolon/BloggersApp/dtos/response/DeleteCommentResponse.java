package com.semicolon.BloggersApp.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeleteCommentResponse {
private String message;
private LocalDateTime deletedAt = LocalDateTime.now();
}

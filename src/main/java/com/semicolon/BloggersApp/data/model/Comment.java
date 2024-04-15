package com.semicolon.BloggersApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("comments")
public class Comment {
    private String id;
    private String comment;
    private String userName;
    private LocalDateTime dateTime = LocalDateTime.now();
}

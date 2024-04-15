package com.semicolon.BloggersApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("views")
public class View {
    private String id;
    @DBRef
    private User viewer;

    private LocalDateTime timeView = LocalDateTime.now();
}

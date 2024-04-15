package com.semicolon.BloggersApp.data.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Post {
    private String id;
    private String userName;
    private String title;
    private String content;
    @DBRef
    private List<View> views = new ArrayList<>();
    @DBRef
    private List<User> user = new ArrayList<>();
    private List<Comment> comments =  new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

}

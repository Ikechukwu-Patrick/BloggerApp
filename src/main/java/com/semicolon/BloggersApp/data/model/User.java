package com.semicolon.BloggersApp.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("users")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean isLocked;
    private LocalDateTime dateCreated = LocalDateTime.now();
    @DBRef
    private List<Post> posts = new ArrayList<>();
    @DBRef
    private List<Comment> comments = new ArrayList<>();
    @DBRef
    private List<View> views = new ArrayList<>();


}

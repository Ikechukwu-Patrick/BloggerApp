package com.semicolon.BloggersApp.data.repositories;

import com.semicolon.BloggersApp.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

}

package com.semicolon.BloggersApp.data.repositories;

import com.semicolon.BloggersApp.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}

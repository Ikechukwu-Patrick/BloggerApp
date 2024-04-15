package com.semicolon.BloggersApp.data.repositories;

import com.semicolon.BloggersApp.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View, String> {
}

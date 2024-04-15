package com.semicolon.BloggersApp.data.repositories;

import com.semicolon.BloggersApp.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserName(String userName);
    User findUserByUserName(String userName);
    boolean existsUserBy(String userName);

    void delete(String userName);
}

package com.semicolon.BloggersApp.data.services;

import com.semicolon.BloggersApp.data.model.Comment;
import com.semicolon.BloggersApp.data.repositories.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    public void setUpTestCases(){
        commentRepository.deleteAll();

    }
    @Test
    public void commentRepositoryTest(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(comment,commentRepository.count());
    }
}

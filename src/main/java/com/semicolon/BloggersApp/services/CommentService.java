package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.dtos.requests.CreateCommentRequest;
import com.semicolon.BloggersApp.dtos.response.CreateCommentResponse;

public interface CommentService {
   CreateCommentResponse createComment(CreateCommentRequest commentRequest);

    String findCommentByUserId(String id, String userId);

    String deleteCommentById(String id, String commentId);
}

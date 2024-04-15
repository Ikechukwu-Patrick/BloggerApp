package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;

public interface PostService {
    CreatePostResponse createPost(CreatePostRequest createPostRequest);
}

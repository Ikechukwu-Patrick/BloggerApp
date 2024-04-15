package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.requests.LoginUserRequest;
import com.semicolon.BloggersApp.dtos.requests.RegisterUserRequest;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;
import com.semicolon.BloggersApp.dtos.response.LoginUserResponse;
import com.semicolon.BloggersApp.dtos.response.RegisterUserResponse;

public interface UserService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse login(LoginUserRequest loginUserRequest);
    CreatePostResponse creatPost(CreatePostRequest createPostRequest);

    long count();
}

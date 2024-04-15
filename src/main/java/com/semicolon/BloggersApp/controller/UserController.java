package com.semicolon.BloggersApp.controller;

import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.requests.LoginUserRequest;
import com.semicolon.BloggersApp.dtos.requests.RegisterUserRequest;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;
import com.semicolon.BloggersApp.dtos.response.LoginUserResponse;
import com.semicolon.BloggersApp.dtos.response.RegisterUserResponse;
import com.semicolon.BloggersApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest userRequest) {
        RegisterUserResponse userResponse = new RegisterUserResponse();
        try {
            userResponse = userService.registerUser(userRequest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PostMapping("login")
    public ResponseEntity<LoginUserResponse> login(@RequestBody LoginUserRequest loginUserRequest){
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        try {
            loginUserResponse = userService.login(loginUserRequest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(loginUserResponse);
    }
    @PostMapping("createPost")
    public ResponseEntity<CreatePostResponse> createPost(@RequestBody CreatePostRequest createPostRequest){
        CreatePostResponse createPostResponse = new CreatePostResponse();
        try {
            createPostResponse = userService.creatPost(createPostRequest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createPostResponse);

    }
}

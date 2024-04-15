package com.semicolon.BloggersApp.utils;

import com.semicolon.BloggersApp.data.model.Comment;
import com.semicolon.BloggersApp.data.model.Post;
import com.semicolon.BloggersApp.data.model.User;
import com.semicolon.BloggersApp.dtos.requests.*;
import com.semicolon.BloggersApp.dtos.response.CreateCommentResponse;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;
import com.semicolon.BloggersApp.dtos.response.LoginUserResponse;
import com.semicolon.BloggersApp.dtos.response.RegisterUserResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setUserName(registerUserRequest.getUserName());
        user.setPassWord(registerUserRequest.getPassWord());
        return user;
    }

    public static RegisterUserResponse register(User objectUser) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
//        registerUserResponse.setId(objectUser.getId());
//        registerUserResponse.setUserName(objectUser.getUserName());
        registerUserResponse.setDateCreated(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
        registerUserResponse.setMessage("Registered successfully");
        return registerUserResponse;

    }

    public static LoginUserResponse loginResponse(LoginUserRequest registerUser) {
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setId(registerUser.getPassWord());
        loginUserResponse.setUserName(registerUser.getUserName());
        loginUserResponse.setMessage("Login successful");
        return loginUserResponse;

    }

    public static Post createPostMap(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setUserName(createPostRequest.getUserName());
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(post.getUser());
        User user = new User();
        user.setPosts(user.getPosts());

        return post;
    }

    public static CreatePostResponse mapCreatePost(Post createdPost) {
        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setId(createdPost.getId());
        createPostResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));

        return createPostResponse;


    }

    public static Comment createCommentMethod(CreateCommentRequest commentRequest) {
        Comment newComment = new Comment();
        newComment.setComment(commentRequest.getComment());
        newComment.setDateTime(LocalDateTime.now());
        newComment.setUserName(newComment.getUserName());
        User userComment = new User();
        userComment.setComments(userComment.getComments());
        return newComment;
    }

    public static CreateCommentResponse mapCreateComment(Comment createdComment) {
        CreateCommentResponse createCommentResponse = new CreateCommentResponse();
        createCommentResponse.setId(createdComment.getId());
        createCommentResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now()));
        return createCommentResponse;
    }
}

//    public static Comment mapDeleteComment(DeleteCommentRequest deleteCommentRequest){
//    Comment comment =
//
//    }

//    private static DeleteCommentResponse deleteCommentResponse(Comment comment){
//        DeleteCommentResponse deleteCommentResponse = new DeleteCommentResponse();
//        deleteCommentResponse.setMessage("delete successful");
//        return deleteCommentResponse;
//    }
//
//
//
//
//
//
//}

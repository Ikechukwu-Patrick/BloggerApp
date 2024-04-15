package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.data.model.User;
import com.semicolon.BloggersApp.data.repositories.UserRepository;
import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.requests.LoginUserRequest;
import com.semicolon.BloggersApp.dtos.requests.RegisterUserRequest;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;
import com.semicolon.BloggersApp.dtos.response.LoginUserResponse;
import com.semicolon.BloggersApp.dtos.response.RegisterUserResponse;
import com.semicolon.BloggersApp.exceptions.IncorrectPasswordException;
import com.semicolon.BloggersApp.exceptions.UserAlreadyExistException;
import com.semicolon.BloggersApp.exceptions.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.semicolon.BloggersApp.utils.Mapper.*;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PostServiceImplement postService;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        validateUserName(registerUserRequest.getUserName());
        User user = map(registerUserRequest);
        userRepository.save(user);
        RegisterUserResponse userResponse = register(user);
        return userResponse ;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        User registerUser = findByUserName(loginUserRequest.getUserName().toUpperCase());
        String generatedPassword = loginUserRequest.getPassWord();
        String savedPassword = registerUser.getPassWord();
        if (validatePassword(generatedPassword, savedPassword)) {
            registerUser.setLocked(false);
            userRepository.save(registerUser);
        }
        LoginUserResponse userResponse = loginResponse(loginUserRequest);
        return userResponse;
    }

    @Override
    public CreatePostResponse creatPost(CreatePostRequest createPostRequest) {
        return null;
    }

//    @Override
//    public CreatePostResponse creatPost(CreatePostRequest createPostRequest) {
//        User user = findByUserName(createPostRequest.getUserName());
//        Post createdPost = postService.createPost(createPostRequest);
//        user.getPosts().add(createdPost);
//        userRepository.save(user);
//        return mapCreatePost(createdPost);
//    }

    @Override
    public long count() {
        return userRepository.count();
    }

    private boolean validatePassword(String savedPassword, String generatedPassword) {
        if (generatedPassword.equals(savedPassword)) return true;
        else throw new IncorrectPasswordException
                (String.format("%s The password you provided was not registered, enter your register password", generatedPassword));

    }

    private User findByUserName(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isEmpty()) throw new UserDoesNotExistException
                (String.format("%s Sorry the user name you provided was not registered, enter registered name", username));
        return user.get();
    }

    private void validateUserName(String userName) {
        User foundUser = userRepository.findUserByUserName(userName);
        if (foundUser != null) {
            if (foundUser.getUserName().equals(userName)) {
                throw new UserAlreadyExistException(String.format("%s User already exist", userName));

            }
        }

    }
}




package com.semicolon.BloggersApp.data.services;

import com.semicolon.BloggersApp.data.model.User;
import com.semicolon.BloggersApp.data.repositories.UserRepository;
import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.requests.LoginUserRequest;
import com.semicolon.BloggersApp.dtos.requests.RegisterUserRequest;
import com.semicolon.BloggersApp.exceptions.IncorrectPasswordException;
import com.semicolon.BloggersApp.exceptions.SomeOtherExistException;
import com.semicolon.BloggersApp.exceptions.UserAlreadyExistException;
import com.semicolon.BloggersApp.services.PostService;
import com.semicolon.BloggersApp.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userServices;
    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;

    @Nested
public class RepositoryTest {

     @Autowired
        private UserRepository userRepository;






        @BeforeEach
        public void setUpTestCases() {
            userRepository.deleteAll();
        }

        @Test

        public void saveTest() {
            User user = new User();
            userRepository.save(user);
            assertEquals(1, userRepository.count());
        }
    }

    @Test
    public void test_that_if_the_same_user_register_twice_throw_exception(){
       try {
           RegisterUserRequest registerUserRequest = new RegisterUserRequest();
           registerUserRequest.setFirstName("Iykey");
           registerUserRequest.setLastName("Patrick");
           registerUserRequest.setUserName("Omiewa");
           registerUserRequest.setPassWord("098y6");
           userServices.registerUser(registerUserRequest);
           assertThrows(UserAlreadyExistException.class,()->userServices.registerUser(registerUserRequest));
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    @Test
    public void test_that_user_can_create_post(){
        try {
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setFirstName("Praise");
            registerUserRequest.setLastName("Oyewole");
            registerUserRequest.setUserName("Israel");
            registerUserRequest.setPassWord("9876");
            userServices.registerUser(registerUserRequest);
            CreatePostRequest createPostRequest = new CreatePostRequest();
            createPostRequest.setTitle("Ikey");
            createPostRequest.setTitle("Things fall apart");
            createPostRequest.setContent("We were one before things fall apart");
            var createPostResponse = postService.createPost(createPostRequest);
            assertThrows(SomeOtherExistException.class, () -> userServices.creatPost(createPostRequest));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void test_that_user_can_login(){
        try {
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setFirstName("Praise");
            registerUserRequest.setLastName("Oyewole");
            registerUserRequest.setUserName("Israel");
            registerUserRequest.setPassWord("9876");
            userServices.registerUser(registerUserRequest);
            LoginUserRequest loginUserRequest = new LoginUserRequest();
            loginUserRequest.setUserName("Praise");
            loginUserRequest.setPassWord("9876");
            userServices.login(loginUserRequest);
            Optional<User> user = Optional.ofNullable(userRepository.findUserByUserName("Israel"));
            assertTrue(user.isPresent());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void test_that_user_login_with_wrong_password_throw_exception(){
        try {
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setFirstName("Praise3");
            registerUserRequest.setLastName("Oyewole3");
            registerUserRequest.setUserName("Israel3");
            registerUserRequest.setPassWord("9876");
            userServices.registerUser(registerUserRequest);
            LoginUserRequest loginUserRequest = new LoginUserRequest();
            loginUserRequest.setUserName("Israel3");
            loginUserRequest.setPassWord("9870");
            userServices.login(loginUserRequest);
            assertThrows(IncorrectPasswordException.class, () -> userServices.login(loginUserRequest));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}



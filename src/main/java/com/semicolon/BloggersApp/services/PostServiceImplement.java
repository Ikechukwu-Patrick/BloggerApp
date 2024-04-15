package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.data.model.Post;
import com.semicolon.BloggersApp.data.repositories.PostRepository;
import com.semicolon.BloggersApp.data.repositories.UserRepository;
import com.semicolon.BloggersApp.dtos.requests.CreatePostRequest;
import com.semicolon.BloggersApp.dtos.response.CreatePostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.BloggersApp.utils.Mapper.createPostMap;
import static com.semicolon.BloggersApp.utils.Mapper.mapCreatePost;

@Service
public class PostServiceImplement implements PostService{

 @Autowired
 private PostRepository postRepository;

 @Autowired
 private UserRepository userRepository;


    @Override
    public CreatePostResponse createPost(CreatePostRequest createPostRequest) {
       Post newPost = createPostMap(createPostRequest);
//        createPostRequest.setUserName(createPostRequest.getUserName().toUpperCase());
//        createPostRequest.setTitle(createPostRequest.getTitle().toUpperCase());
//        createPostRequest.setContent(createPostRequest.getContent());
        //createPostRequest.setCreatedAt(LocalDateTime.parse(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now())));
        return mapCreatePost(newPost);
    }

}

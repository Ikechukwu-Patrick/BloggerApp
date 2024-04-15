package com.semicolon.BloggersApp.services;

import com.semicolon.BloggersApp.data.model.Comment;
import com.semicolon.BloggersApp.data.model.Post;
import com.semicolon.BloggersApp.data.repositories.CommentRepository;
import com.semicolon.BloggersApp.data.repositories.PostRepository;
import com.semicolon.BloggersApp.data.repositories.UserRepository;
import com.semicolon.BloggersApp.dtos.requests.CreateCommentRequest;
import com.semicolon.BloggersApp.dtos.response.CreateCommentResponse;
import com.semicolon.BloggersApp.exceptions.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImplement implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

//    @Override
//    public CreateCommentResponse createComment(CreateCommentRequest commentRequest) {
//        Comment newPost = new Comment();
//        newPost.setComment(commentRequest.getComment());
//        newPost.setUserName(commentRequest.getUserName());
//        commentRepository.save(newPost);
//        CreatePostResponse createPostResponse
//    }

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest commentRequest) {
        return null;
    }

    @Override
    public String findCommentByUserId(String id, String userId) {
        String userComment = searchCommentById(id,userId);
        userRepository.findByUserName(userComment);

        return userComment;
    }

    @Override
    public String deleteCommentById(String id, String commentId) {
        String deleteUser = searchCommentById(id, commentId);
        userRepository.delete(deleteUser);
        return "Comment deleted successfully";
    }
//
//    private String findCommentById(String username) {
//        Optional<Post> post = postRepository
//
//        if (!username.equals(userToDelete.getUserName())) throw new UserNotFoundException("User not found");
//        return userToDelete;
//    }

    private String searchCommentById(String id, String userCommentNameId) {
        Optional<Post> postOptional = postRepository.findById(id);
        List<Comment> allPostComments = postOptional.get().getComments();
        for (int i = 0; i < allPostComments.size(); i++) {
            if (!allPostComments.get(i).getId().equals(userCommentNameId)) {
                return allPostComments.get(i).getId();
            }
        }
        throw new CommentNotFoundException("Sorry comment not found");

    }
    public String updateCommentById(String id,String commentId){
       Optional <Post> optionalPost = postRepository.findById(id);
        List <Comment> allComments = optionalPost.get().getComments();
        for (int i = 0; i < allComments.size() ; i++) {
            if (allComments.get(i).getId().equals(commentId)){
                allComments.get(i).setComment("6575y");
                commentRepository.save(allComments.get(i));
            }
        }
        return  "Comment updated successfully!";
    }



}

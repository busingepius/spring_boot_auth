package org.example.lab2.service.impl;

import org.example.lab2.aspect.ExecutionTime;
import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.User;
import org.example.lab2.entity.dto.request.CommentDto;
import org.example.lab2.entity.dto.request.PostDto;
import org.example.lab2.entity.dto.request.UserDto;
import org.example.lab2.repo.CommentRepo;
import org.example.lab2.repo.PostRepo;
import org.example.lab2.repo.UserRepo;
import org.example.lab2.service.CommentService;
import org.example.lab2.service.PostService;
import org.example.lab2.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @ExecutionTime
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            //throw new RuntimeException();
            return user.get();
        }
        return null;
    }

    public List<Post> getUserPosts(Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            return user.getPosts();
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> userToDelete = userRepo.findById(id);
        if (userToDelete.isPresent()) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public Comment getCommentByUserPostComment(Long userId, Long postId, Long commentId) {
        User user = getUserById(userId);
        if (user!=null){
            Post post = postService.getPostById(postId);
            if (post!=null && user.getPosts().contains(post)){
                Comment comment = commentService.getCommentById(postId);
                if (comment!=null && post.getComments().contains(comment)){
                    return comment;
                }
            }
        }
        return null;
    }

    @Override
    public Post getPostByUser(Long userId, Long postId) {
        User user = getUserById(userId);
        if (user!=null){
            Post post = postService.getPostById(postId);
            if (post!=null && user.getPosts().contains(post)){
                return post;
            }
        }
        return null;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

}

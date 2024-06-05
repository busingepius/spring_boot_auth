package org.example.lab2.controller;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.User;
import org.example.lab2.entity.dto.request.PostDto;
import org.example.lab2.entity.dto.request.UserDto;
import org.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Long id){
        return userService.getUserPosts(id);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment getCommentByUserPostComment(
            @PathVariable Long userId,
            @PathVariable Long postId,
            @PathVariable Long commentId){
        return userService.getCommentByUserPostComment(userId, postId, commentId);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public Post getPostByUser(
            @PathVariable Long userId,
            @PathVariable Long postId){
        return userService.getPostByUser(userId, postId);
    }
}

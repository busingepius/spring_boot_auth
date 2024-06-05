package org.example.lab2.service;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.User;
import org.example.lab2.entity.dto.request.UserDto;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();


    User getUserById(Long id);

    void createUser(UserDto userDto);

    List<Post> getUserPosts(Long id);

    void deleteUserById(Long id);

    Comment getCommentByUserPostComment(Long userId, Long postId, Long commentId);

    Post getPostByUser(Long userId, Long postId);
}

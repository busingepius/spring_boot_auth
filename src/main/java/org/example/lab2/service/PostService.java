package org.example.lab2.service;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.dto.request.CommentDto;
import org.example.lab2.entity.dto.request.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts(String author);

    Post getPostById(long postId);

    void createPost(PostDto postDto);

    void updatePostById(Long id, PostDto postDto);

    void deletePostById(Long id);

    void createComment(CommentDto commentDto, Long id);

    List<Comment> getPostComment(Long id);
}

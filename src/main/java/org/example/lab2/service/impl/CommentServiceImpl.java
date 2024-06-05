package org.example.lab2.service.impl;

import org.example.lab2.entity.Comment;
import org.example.lab2.repo.CommentRepo;
import org.example.lab2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;
    public Comment getCommentById(long commentId) {
        Optional<Comment> comment = commentRepo.findById(commentId);
        if (comment.isPresent()) {
            return comment.get();
        }
        return null;
    }
}

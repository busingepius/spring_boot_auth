package org.example.lab2.controller;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.dto.request.CommentDto;
import org.example.lab2.entity.dto.request.PostDto;
import org.example.lab2.repo.PostRepo;
import org.example.lab2.service.PostService;
import org.example.lab2.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> getAllPosts(
            @RequestParam(name = "author", required = false) String author
    ){
        return postService.getAllPosts(author);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public void updatePost(@RequestBody PostDto postDto, @PathVariable Long id){
        postService.updatePostById(id, postDto);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/comments")
    public void createComment(@RequestBody CommentDto commentDto, @PathVariable Long id){
        postService.createComment(commentDto,id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/comments")
    public List<Comment> getCommentByPostId(@PathVariable Long id){
        return postService.getPostComment(id);
    }




}

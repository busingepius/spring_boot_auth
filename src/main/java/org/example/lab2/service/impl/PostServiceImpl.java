package org.example.lab2.service.impl;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.User;
import org.example.lab2.entity.dto.request.CommentDto;
import org.example.lab2.entity.dto.request.PostDto;
import org.example.lab2.repo.PostRepo;
import org.example.lab2.service.PostService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Post> getAllPosts(String author) {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(long postId) {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
    }

    @Override
    public void updatePostById(Long id, PostDto postDto) {
        Optional<Post> postToUpdate = postRepo.findById(id);
        if (postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            post.setAuthor(postDto.getAuthor());
            post.setContent(postDto.getContent());
            post.setTitle(postDto.getTitle());
        }
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> postToDelete = postRepo.findById(id);
        if (postToDelete.isPresent()) {
            postRepo.deleteById(id);
        }
    }

    @Override
    public void createComment(CommentDto commentDto, Long id) {
        Post post = getPostById(id);
        Comment comment = modelMapper.map(commentDto,Comment.class);
        post.addComment(comment);
    }

    @Override
    public List<Comment> getPostComment(Long id) {
        Post post = getPostById(id);
        if (post != null) {
            return post.getComments();
        }
        return new ArrayList<>();
    }

}


/*
public List<Post> getAllPosts(String author) {
        return author==null?posts: getAllPostsByAuthor(author);
    }

    public List<Post> getAllPostsByAuthor(String author) {
        return posts.stream()
                .filter(post -> post.getAuthor().toLowerCase().equals(author))
                .toList();
    }



    public Optional<Post> getPostById(long postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst();
    }
    public void createPost(Post post) {
        post.setId(Post.count++);
        posts.add(post);
    }

    @Override
    public void updatePostById(Long id, PostDto updatedPost) {
        Optional<Post> postToUpdate = getPostById(id);
        if (postToUpdate.isPresent()) {
            Post post = postToUpdate.get();
            post.setAuthor(updatedPost.getAuthor());
            post.setContent(updatedPost.getContent());
            post.setTitle(updatedPost.getTitle());
        }
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> userToDelete = getPostById(id);
        if (userToDelete.isPresent()) {
            posts.remove(userToDelete.get());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        posts = new ArrayList<>();
        posts.add(new Post(Post.count++, "Book 1", "Content of Book 1", "Author 1"));
        posts.add(new Post(Post.count++, "Book 2", "Content of Book 2", "Author 2"));
        posts.add(new Post(Post.count++, "Book 3", "Content of Book 3", "Author 3"));
        posts.add(new Post(Post.count++, "Book 4", "Content of Book 4", "Author 4"));
        posts.add(new Post(Post.count++, "Book 5", "Content of Book 5", "Author 5"));

    }

 */
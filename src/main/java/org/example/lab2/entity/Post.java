package org.example.lab2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    String author;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "post_id")
    List<Comment> comments;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();

    }

    public void addComment(Comment comment){
        comments.add(comment);
    }
}
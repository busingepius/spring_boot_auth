package org.example.lab2.repo;

import org.example.lab2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findPostsByTitle(String title);
}

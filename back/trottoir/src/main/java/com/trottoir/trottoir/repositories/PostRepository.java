package com.trottoir.trottoir.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trottoir.trottoir.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    Optional<Post> findById(Long id);
}

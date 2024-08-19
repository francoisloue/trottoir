package com.trottoir.trottoir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trottoir.trottoir.entities.Post;
import com.trottoir.trottoir.repositories.PostRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostServiceImplementation implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

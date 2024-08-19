package com.trottoir.trottoir.services;

import java.util.List;

import com.trottoir.trottoir.entities.Post;

public interface PostService {
    void save(Post post);
    
    List<Post> findAll();
}

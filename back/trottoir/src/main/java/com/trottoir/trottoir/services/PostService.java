package com.trottoir.trottoir.services;

import java.util.List;

import com.trottoir.trottoir.dtos.PostDTO;
import com.trottoir.trottoir.entities.Post;

public interface PostService {
    void save(PostDTO post);
    
    List<Post> findAll();
}

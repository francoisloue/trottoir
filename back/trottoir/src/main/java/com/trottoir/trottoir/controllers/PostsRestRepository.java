package com.trottoir.trottoir.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trottoir.trottoir.entities.Post;
import com.trottoir.trottoir.dtos.PostDTO;
import com.trottoir.trottoir.services.PostService;

@RestController
public class PostsRestRepository {
    private final PostService postService;

    @Autowired
    public PostsRestRepository(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/posts/all")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping(path = "/posts")
    public void createPost(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
    }
}

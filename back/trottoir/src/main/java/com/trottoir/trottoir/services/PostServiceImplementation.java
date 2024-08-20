package com.trottoir.trottoir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trottoir.trottoir.entities.Post;
import com.trottoir.trottoir.entities.User;
import com.trottoir.trottoir.repositories.PostRepository;
import com.trottoir.trottoir.repositories.UserRepository;
import com.trottoir.trottoir.dtos.PostDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostServiceImplementation implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void save(PostDTO postDTO) {
        User author = userRepository.findById(postDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setAuthor(author);
        post.setLikeCount(postDTO.getLikeCount());

        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

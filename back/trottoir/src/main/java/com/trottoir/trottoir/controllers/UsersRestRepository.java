package com.trottoir.trottoir.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trottoir.trottoir.dtos.LoginDTO;
import com.trottoir.trottoir.entities.User;
import com.trottoir.trottoir.services.UserService;



@RestController
public class UsersRestRepository {
    private final UserService userService;
    
    public UsersRestRepository(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/users/all")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/login")
    public Long login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO.getEmail(), loginDTO.getPassword());
    }
    
}
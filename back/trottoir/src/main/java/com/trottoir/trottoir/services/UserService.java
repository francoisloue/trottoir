package com.trottoir.trottoir.services;

import java.util.List;

import com.trottoir.trottoir.entities.User;



public interface UserService{

    void save(User user);

    List<User> findAll();

}
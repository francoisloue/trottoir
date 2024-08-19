package com.trottoir.trottoir.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trottoir.trottoir.entities.User;
import com.trottoir.trottoir.repositories.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) { 
        userRepository.save(user);    
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Long login(String email,String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password))return user.get().getId();
        }
        return (long) 0;
    }

}
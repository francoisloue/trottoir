package com.trottoir.trottoir.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trottoir.trottoir.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
package com.setplex.middleware.repository;

import com.setplex.middleware.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
}

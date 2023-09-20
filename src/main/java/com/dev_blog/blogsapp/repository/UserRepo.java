package com.dev_blog.blogsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev_blog.blogsapp.model.User;

// Provides functionalities to perform on User entity
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
}

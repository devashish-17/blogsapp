package com.dev_blog.blogsapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev_blog.blogsapp.payloads.UserDto;

@Service
public interface UserService {
    
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer user_id);
    UserDto getUserById(Integer user_id);
    List<UserDto> getAllUsers();
    void deleteUser(Integer user_id);
}

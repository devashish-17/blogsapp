package com.dev_blog.blogsapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.dev_blog.blogsapp.exceptions.ResourceNotFoundException;
import com.dev_blog.blogsapp.model.User;
import com.dev_blog.blogsapp.payloads.UserDto;
import com.dev_blog.blogsapp.repository.UserRepo;
import com.dev_blog.blogsapp.services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUserEntity(userDto);
        User savedUser = this.userRepo.save(user);
        return this.entityUserToDto(savedUser);
    }

    @Override
    public UserDto  updateUser(UserDto userDto, Integer user_id) {
        User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User", " id ", user_id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.entityUserToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer user_id) {
        User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User", " id ", user_id));
        return this.entityUserToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> usersList = this.userRepo.findAll();
        List<UserDto> userDtos = usersList.stream().map(user -> this.entityUserToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer user_id) {
        User user = this.userRepo.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User", " id ", user_id));
        this.userRepo.delete(user);
    }

    public User dtoToUserEntity(UserDto userDto) {
        User user = new User();
        user.setUser_id(userDto.getUser_id());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto entityUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUser_id(user.getUser_id());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
    
}

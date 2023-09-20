package com.dev_blog.blogsapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

// similar to User entity, but can expose and connect with services package.
// User entity is used just to showing database

public class UserDto {
    
    private int user_id;
    private String name;
    private String email;
    private String password;
    private String about;
}

package com.LinteRobert.springboot101.mappers;

import com.LinteRobert.springboot101.dtos.PostUser;
import com.LinteRobert.springboot101.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User postUserToUser(PostUser postUser) {
        return new User(postUser.getName(), postUser.getEmail(), postUser.getRole(), this.passwordEncoder.encode(postUser.getPassword()));
    }
}

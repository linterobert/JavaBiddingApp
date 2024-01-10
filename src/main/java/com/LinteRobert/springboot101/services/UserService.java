package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.Image;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.exceptions.UserNotFoundException;
import com.LinteRobert.springboot101.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return true;
        } else {
            throw new UserNotFoundException();
        }
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    public Boolean changePassword(String email, String password, String newPassword) {
        if(login(email, password)) {
            User user = userRepository.findByEmail(email).get();
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}

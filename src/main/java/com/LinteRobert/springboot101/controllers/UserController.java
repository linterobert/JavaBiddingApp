package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.AddFunds;
import com.LinteRobert.springboot101.dtos.ChangePassword;
import com.LinteRobert.springboot101.dtos.LoginDto;
import com.LinteRobert.springboot101.dtos.PostUser;
import com.LinteRobert.springboot101.entities.CreditCard;
import com.LinteRobert.springboot101.entities.User;
import com.LinteRobert.springboot101.mappers.UserMapper;
import com.LinteRobert.springboot101.services.CreditCardService;
import com.LinteRobert.springboot101.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/create")
    public User saveUser(@RequestBody PostUser postUser) {
        return userService.create(userMapper.postUserToUser(postUser));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        userService.login(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(loginDto.getEmail());
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePassword changePassword){
        userService.changePassword(changePassword.getEmail(), changePassword.getPassword(), changePassword.getNewPassword());
        return ResponseEntity.ok(changePassword.getEmail());
    }

    @PostMapping("/addFunds")
    public ResponseEntity<Double> addFunds(@RequestBody AddFunds funds) {
        User user = userService.findById(funds.getUserId());
        CreditCard creditCard = creditCardService.getById(funds.getCardId());
        user.setSold(user.getSold() + funds.getSum());
        userService.create(user);
        return ResponseEntity.ok(user.getSold());
    }
}

package com.LinteRobert.springboot101.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Wrong username or password!");
    }
}
package com.LinteRobert.springboot101.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(int id) {
        super("Review with id " + id + " doesn't exist ");
    }
}

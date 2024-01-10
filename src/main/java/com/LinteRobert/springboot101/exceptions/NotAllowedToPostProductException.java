package com.LinteRobert.springboot101.exceptions;

public class NotAllowedToPostProductException extends RuntimeException{
    public NotAllowedToPostProductException() {
        super("You're not allowed to post a product!");
    }
}

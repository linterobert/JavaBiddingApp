package com.LinteRobert.springboot101.exceptions;

public class NotAllowedToMakeBitException extends RuntimeException{
    public NotAllowedToMakeBitException() {
        super("User not allowed to make a bit!");
    }
}

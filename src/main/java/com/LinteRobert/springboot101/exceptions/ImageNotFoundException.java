package com.LinteRobert.springboot101.exceptions;

public class ImageNotFoundException extends RuntimeException{
    public ImageNotFoundException(int id) {
        super("Image with id " + id + " not found!");
    }
}

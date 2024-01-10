package com.LinteRobert.springboot101.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(int id) {
        super("Product with id " + id + " doesn't exist ");
    }
}

package com.LinteRobert.springboot101.exceptions;

public class CreditCardNotFoundException  extends RuntimeException{
    public CreditCardNotFoundException(int id) {
        super("Credit card with id " + id + " not found!");
    }
}

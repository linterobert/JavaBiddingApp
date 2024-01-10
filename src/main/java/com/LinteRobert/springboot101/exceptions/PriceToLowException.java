package com.LinteRobert.springboot101.exceptions;

public class PriceToLowException extends RuntimeException{
    public PriceToLowException() {
        super("Price to low to make a bit!");
    }
}

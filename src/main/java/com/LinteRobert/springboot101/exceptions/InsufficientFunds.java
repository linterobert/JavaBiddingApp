package com.LinteRobert.springboot101.exceptions;

public class InsufficientFunds extends RuntimeException{
    public InsufficientFunds() {
        super("Insufficient Funds");
    }
}
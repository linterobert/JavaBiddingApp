package com.LinteRobert.springboot101.dtos;

import java.util.Date;

public class ReturnCreditCard {
    private int id;
    private String cardNumber;
    private String cvc;
    private Date expireDate;
    private int userId;

    public ReturnCreditCard() {
    }

    public ReturnCreditCard(int id, String cardNumber, String cvc, Date expireDate, int userId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expireDate = expireDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

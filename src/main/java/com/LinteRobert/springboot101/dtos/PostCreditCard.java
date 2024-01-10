package com.LinteRobert.springboot101.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostCreditCard {
    private String cardNumber;
    private String cvc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiredDate;
    private int userId;

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

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

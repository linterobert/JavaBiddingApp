package com.LinteRobert.springboot101.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreditCardNumber
    private String cardNumber;
    @Length(min = 3, max = 3)
    private String cvc;
    private Date expiredDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CreditCard(String cardNumber, String cvc, Date expiredDate) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiredDate = expiredDate;
    }

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String cvc, Date expiredDate, User user) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiredDate = expiredDate;
        this.user = user;
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

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

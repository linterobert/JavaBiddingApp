package com.LinteRobert.springboot101.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "starsNumber")
    @Min(1)
    @Max(5)
    private int starsNumber;
    @Length(min = 5, max = 250)
    private String Text;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private LocalDateTime postedTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Review(int id, int starsNumber, String text, Product product) {
        this.id = id;
        this.starsNumber = starsNumber;
        this.Text = text;
        this.product = product;
        this.postedTime = LocalDateTime.now();
    }

    public Review(int starsNumber, String text, Product product) {
        this.starsNumber = starsNumber;
        this.Text = text;
        this.product = product;
        this.postedTime = LocalDateTime.now();
    }

    public Review(int starsNumber, String text) {
        this.starsNumber = starsNumber;
        this.Text = text;
        this.postedTime = LocalDateTime.now();
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }
}

package com.LinteRobert.springboot101.dtos;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class ReturnNotification {
    private int id;
    private String text;
    private LocalDateTime createdDate;
    private String email;

    public ReturnNotification(int id, String text, LocalDateTime createdDate, String email) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.email = email;
    }

    public ReturnNotification(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

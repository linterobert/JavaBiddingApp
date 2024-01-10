package com.LinteRobert.springboot101.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    private int id;
    private String text;
    private LocalDateTime createdTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Notification(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Notification(String text) {
        this.text = text;
    }

    public Notification(int id, String text, LocalDateTime createdTime, User user) {
        this.id = id;
        text = text;
        this.createdTime = createdTime;
        this.user = user;
    }

    public Notification() {

    }

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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

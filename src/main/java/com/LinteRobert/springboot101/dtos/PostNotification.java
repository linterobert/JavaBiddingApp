package com.LinteRobert.springboot101.dtos;

public class PostNotification {
    private String text;
    private int userId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

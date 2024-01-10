package com.LinteRobert.springboot101.dtos;

public class UpdateReview {
    private int starsNumber;
    private String Text;

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
}

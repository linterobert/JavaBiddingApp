package com.LinteRobert.springboot101.dtos;

import java.time.LocalDateTime;

public class PostReviewResponse {
    private int id;
    private int starsNumber;
    private String Text;
    private PostReviewProductResponse product;
    private LocalDateTime postedTime;

    public PostReviewResponse() {
    }

    public PostReviewResponse(int id, int starsNumber, String text, PostReviewProductResponse product, LocalDateTime postedTime) {
        this.id = id;
        this.starsNumber = starsNumber;
        Text = text;
        this.product = product;
        this.postedTime = postedTime;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
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

    public PostReviewProductResponse getProduct() {
        return product;
    }

    public void setProduct(PostReviewProductResponse product) {
        this.product = product;
    }
}

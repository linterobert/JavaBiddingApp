package com.LinteRobert.springboot101.dtos;

import com.LinteRobert.springboot101.entities.Image;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class PostProductResponse {
    private int id;
    private String name;

    private Double price;
    private List<PostProductImageResponse> images;
    private LocalDateTime postedTime;
    private LocalDateTime endTime;

    public PostProductResponse(int id, String name, Double price, List<PostProductImageResponse> images, LocalDateTime postedTime, LocalDateTime endTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.postedTime = postedTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<PostProductImageResponse> getImages() {
        return images;
    }

    public void setImages(List<PostProductImageResponse> images) {
        this.images = images;
    }

    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

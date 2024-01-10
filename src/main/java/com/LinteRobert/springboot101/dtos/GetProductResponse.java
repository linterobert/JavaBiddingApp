package com.LinteRobert.springboot101.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class GetProductResponse {
    private int id;
    private String name;

    private Double price;
    private List<GetProductsImageResponse> image;
    private LocalDateTime postedTime;
    private LocalDateTime endTime;

    public GetProductResponse(int id, String name, Double price, List<GetProductsImageResponse> image, LocalDateTime postedTime, LocalDateTime endTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.postedTime = postedTime;
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public List<GetProductsImageResponse> getImage() {
        return image;
    }

    public void setImage(List<GetProductsImageResponse> image) {
        this.image = image;
    }
}

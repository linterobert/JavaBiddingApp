package com.LinteRobert.springboot101.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import javax.management.ConstructorParameters;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Length(min = 2, max = 50)
    private String name;
    @Min(0)
    private Double price;

    private LocalDateTime postedTime;
    private LocalDateTime endTime;
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Image> images;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Product() {
        postedTime = LocalDateTime.now();
    }

    public Product(int id, String name, Double price, List<Image> images, List<Review> reviews, LocalDateTime endTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.images = images;
        this.reviews = reviews;
        postedTime = LocalDateTime.now();
        this.endTime = endTime;
    }

    public Product(String name, Double price, List<Image> images, LocalDateTime endTime) {
        this.name = name;
        this.price = price;
        this.images = images;
        postedTime = LocalDateTime.now();
        this.endTime = endTime;
    }

    public Product(String name, Double price, LocalDateTime endTime, User user) {
        this.name = name;
        this.price = price;
        this.endTime = endTime;
        this.user = user;
        postedTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
    public LocalDateTime getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(LocalDateTime postedTime) {
        this.postedTime = postedTime;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

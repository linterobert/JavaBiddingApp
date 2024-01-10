package com.LinteRobert.springboot101.services;

import com.LinteRobert.springboot101.entities.Review;
import com.LinteRobert.springboot101.exceptions.ReviewNotFoundException;
import com.LinteRobert.springboot101.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review Create(Review review) {
        return reviewRepository.save(review);
    }
    public List<Review> GetAll() { return reviewRepository.findAll(); }
    public Review GetReviewById(int id) {
        Optional<Review> review = reviewRepository.findById(id);

        if (review.isPresent()) {
            return review.get();
        } else {
            throw new ReviewNotFoundException(id);
        }
    }
    public void DeleteReview(int id) {
        reviewRepository.deleteById(id);
    }
    public List<Review> FindReviewsByProductId(int id) {
        return reviewRepository.findReviewsByProductId(id);
    }
    public Review UpdateReview(Review review) {
        return reviewRepository.save(review);
    }
    public List<Review> GetReviewByProductIdByPage(int id, Pageable p) { return reviewRepository.findReviewsByProductId(id, p); }
}

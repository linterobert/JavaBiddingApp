package com.LinteRobert.springboot101.controllers;
import com.LinteRobert.springboot101.consts.Constants;
import com.LinteRobert.springboot101.dtos.*;
import com.LinteRobert.springboot101.entities.Review;
import com.LinteRobert.springboot101.mappers.ReviewMapper;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.ReviewService;
import com.LinteRobert.springboot101.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<PostReviewResponse> addProduct(@RequestBody PostReview postReview) {
        Review review = reviewMapper.PostReviewToReview(postReview);
        review.setProduct(productService.getById(postReview.getProduct_id()));
        review.setUser(userService.findById(postReview.getUser_id()));
        return ResponseEntity.created(URI.create("/review/"+ review.getId()))
                .body(reviewMapper.ReviewToPostReviewResponse(reviewService.Create(review)));
    }

    @GetMapping
    public List<PostReviewResponse> getReviews() {
        List<PostReviewResponse> reviews = new ArrayList<>();
        reviewService.GetAll().forEach(review -> reviews.add(reviewMapper.ReviewToPostReviewResponse(review)));
        return reviews;
    }

    @GetMapping("/id/{id}")
    public PostReviewResponse getReviewById(@PathVariable("id") int id) {
        return reviewMapper.ReviewToPostReviewResponse(reviewService.GetReviewById(id));
    }

    @GetMapping("/productId/{id}")
    public List<PostReviewResponse> getReviewsByProductName(@PathVariable("id") int id) {
        List<PostReviewResponse> reviews = new ArrayList<>();
        reviewService.FindReviewsByProductId(id).forEach(review -> reviews.add(reviewMapper.ReviewToPostReviewResponse(review)));
        return reviews;
    }

    @GetMapping("/productId/{id}/pageNumber/{pageNumber}")
    public List<PostReviewResponse> getReviewsByProductIdByPage(@PathVariable("id") int id,
                                                                @PathVariable("pageNumber") int pageNumber,
                                                                @RequestBody(required = false
                                                                ) SortRequest sortedBy) {
        List<PostReviewResponse> reviews = new ArrayList<>();
        Pageable p;
        if(sortedBy != null) {
            Sort sort;
            if(sortedBy.getAscending()) {
                sort = Sort.by(sortedBy.getField_name()).ascending();
            } else {
                sort = Sort.by(sortedBy.getField_name()).descending();
            }
            p = PageRequest.of(pageNumber, Constants.REVIEW_PAGE_SIZE, sort);
        } else {
            p = PageRequest.of(pageNumber, Constants.REVIEW_PAGE_SIZE);
        }
        reviewService.GetReviewByProductIdByPage(id, p).forEach(review -> reviews.add(reviewMapper.ReviewToPostReviewResponse(review)));
        return reviews;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") int id) {
        reviewService.DeleteReview(id);
        return ResponseEntity.ok("Review deleted successfully!");
    }

    @PutMapping ("/{id}")
    public ResponseEntity<PostReviewResponse> updateReview(@PathVariable("id") int id, @RequestBody UpdateReview updatedReview) {
        Review review = reviewService.GetReviewById(id);
        review.setStarsNumber(updatedReview.getStarsNumber());
        review.setText(updatedReview.getText());
        reviewService.UpdateReview(review);
        PostReviewProductResponse product = reviewMapper.ProductToPostReviewProductResponse(review.getProduct());
        return ResponseEntity.ok(new PostReviewResponse(review.getId(),review.getStarsNumber(), review.getText(), product, review.getPostedTime()));
    }
}

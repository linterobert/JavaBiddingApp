package com.LinteRobert.springboot101.mappers;

import com.LinteRobert.springboot101.dtos.PostReview;
import com.LinteRobert.springboot101.dtos.PostReviewProductResponse;
import com.LinteRobert.springboot101.dtos.PostReviewResponse;
import com.LinteRobert.springboot101.entities.Product;
import com.LinteRobert.springboot101.entities.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review PostReviewToReview(PostReview postReview) {
        return new Review(postReview.getStarsNumber(), postReview.getText());
    }

    public PostReviewProductResponse ProductToPostReviewProductResponse(Product product) {
        return new PostReviewProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    public PostReviewResponse ReviewToPostReviewResponse(Review review) {
        PostReviewProductResponse product = ProductToPostReviewProductResponse(review.getProduct());
        return new PostReviewResponse(review.getId(), review.getStarsNumber(), review.getText(), product, review.getPostedTime());
    }
}

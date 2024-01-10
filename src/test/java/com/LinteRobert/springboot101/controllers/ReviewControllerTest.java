package com.LinteRobert.springboot101.controllers;

import com.LinteRobert.springboot101.dtos.PostReview;
import com.LinteRobert.springboot101.dtos.PostReviewResponse;
import com.LinteRobert.springboot101.entities.Review;
import com.LinteRobert.springboot101.mappers.ReviewMapper;
import com.LinteRobert.springboot101.services.ProductService;
import com.LinteRobert.springboot101.services.ReviewService;
import com.LinteRobert.springboot101.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @Test
    public void testDeleteReview() {
        int reviewId = 123;

        reviewController.deleteReview(reviewId);
        verify(reviewService, times(1)).DeleteReview(reviewId);
    }
}
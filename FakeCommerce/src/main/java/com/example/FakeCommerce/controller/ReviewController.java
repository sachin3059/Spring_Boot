package com.example.FakeCommerce.controller;


import com.example.FakeCommerce.dtos.reviews.ReviewRequestDto;
import com.example.FakeCommerce.dtos.reviews.ReviewResponseDto;
import com.example.FakeCommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewResponseDto> getReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public ReviewResponseDto createReview(@RequestBody ReviewRequestDto dto) {
        return reviewService.createReview(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/{id}")
    public ReviewResponseDto getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/product/{productID}")
    public List<ReviewResponseDto> getReviewsByProductId(@PathVariable Long productID) {
        return reviewService.getReviewsByProductId(productID);
    }

    @GetMapping("/order/{orderId}")
    public List<ReviewResponseDto> getReviewsByOrderId(@PathVariable Long orderId) {
        return reviewService.getReviewsByOrderId(orderId);
    }
}

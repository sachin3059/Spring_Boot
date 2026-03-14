package com.example.FakeCommerce.service;

import com.example.FakeCommerce.dtos.reviews.ReviewRequestDto;
import com.example.FakeCommerce.dtos.reviews.ReviewResponseDto;
import com.example.FakeCommerce.repository.OrderProductRepository;
import com.example.FakeCommerce.repository.OrderRepository;
import com.example.FakeCommerce.repository.ProductRepository;
import com.example.FakeCommerce.repository.ReviewRepository;
import com.example.FakeCommerce.schema.Order;
import com.example.FakeCommerce.schema.Product;
import com.example.FakeCommerce.schema.Review;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    private ReviewResponseDto mapToDto(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .orderId(review.getOrder().getId())
                .productId(review.getProduct().getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(review.getCreatedAt())
                .build();
    }


    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ReviewResponseDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found: " + id));
        return mapToDto(review);
    }

    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviewsByOrderId(Long orderId) {
        return reviewRepository.findByOrder_Id(orderId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ReviewResponseDto> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProduct_Id(productId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }


    public ReviewResponseDto createReview(ReviewRequestDto dto) {

        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + dto.getOrderId()));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found: " + dto.getProductId()));

        boolean purchased = orderProductRepository.existsByOrder_IdAndProduct_Id(dto.getOrderId(), dto.getProductId());
        if (!purchased) {
            throw new IllegalArgumentException("You can review only purchased products for that order.");
        }

        boolean alreadyReviewed = reviewRepository.existsByOrder_IdAndProduct_Id(dto.getOrderId(), dto.getProductId());
        if (alreadyReviewed) {
            throw new IllegalArgumentException("Review already exists for this order and product.");
        }

        Review review = Review.builder()
                .order(order)
                .product(product)
                .rating(dto.getRating())
                .comment(dto.getComment())
                .build();

        Review saved = reviewRepository.save(review);
        return mapToDto(saved);
    }

    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found: " + id));
        reviewRepository.delete(review);
    }

}
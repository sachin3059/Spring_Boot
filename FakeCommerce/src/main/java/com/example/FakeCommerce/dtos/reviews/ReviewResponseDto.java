package com.example.FakeCommerce.dtos.reviews;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponseDto {

    private Long id;
    private Long orderId;
    private Long productId;
    private BigDecimal rating;
    private String comment;
    private LocalDateTime createdAt;
}

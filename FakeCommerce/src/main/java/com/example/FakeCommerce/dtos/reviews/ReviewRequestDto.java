package com.example.FakeCommerce.dtos.reviews;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequestDto {

    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    private BigDecimal rating;

    @NotBlank
    private String comment;
}
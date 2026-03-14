package com.example.FakeCommerce.dtos.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {

    private String title;

    private String description;

    private String image;

    private BigDecimal price;

    private Long categoryId;

    private BigDecimal rating;
}

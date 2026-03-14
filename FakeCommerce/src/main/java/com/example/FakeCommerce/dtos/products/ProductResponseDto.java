package com.example.FakeCommerce.dtos.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductResponseDto {

    private Long id;

    private String title;

    private String description;

    private String image;

    private BigDecimal price;

    private BigDecimal rating;
}

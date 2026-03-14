package com.example.FakeCommerce.dtos.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductWithDetailsResponseDto extends ProductResponseDto {

    private String category;
}

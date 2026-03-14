package com.example.FakeCommerce.dtos.orders;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummaryLineDto {
    private Long productId;
    private String title;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
}

package com.example.FakeCommerce.dtos.orders;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummaryDto {
    private Long orderId;
    private int totalItems;
    private BigDecimal totalAmount;
    private List<OrderSummaryLineDto> lines;
}

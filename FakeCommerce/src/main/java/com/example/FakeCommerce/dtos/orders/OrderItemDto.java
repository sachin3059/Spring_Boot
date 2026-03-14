package com.example.FakeCommerce.dtos.orders;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {

    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Integer quantity;
}

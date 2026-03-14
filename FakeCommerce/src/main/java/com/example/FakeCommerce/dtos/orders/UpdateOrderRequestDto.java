package com.example.FakeCommerce.dtos.orders;


import com.example.FakeCommerce.schema.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateOrderRequestDto {

    @NotNull
    private OrderStatus status;
}

package com.example.FakeCommerce.adapters;

import com.example.FakeCommerce.dtos.orders.OrderItemResponseDto;
import com.example.FakeCommerce.dtos.orders.OrderResponseDto;
import com.example.FakeCommerce.repository.OrderProductRepository;
import com.example.FakeCommerce.schema.Order;
import com.example.FakeCommerce.schema.OrderProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderAdapter {

    private final OrderProductRepository orderProductRepository;

    public List<OrderResponseDto> mapToGetOrderResponseDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::mapToGetOrderResponseDto)
                .collect(Collectors.toList());
    }

    public OrderResponseDto mapToGetOrderResponseDto(Order order) {
        List<OrderProducts> orderProducts = orderProductRepository.findByOrderId(order.getId());
        List<OrderItemResponseDto> items = mapToOrderItemResponseDto(orderProducts);

        return OrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .items(items)
                .build();
    }

    public List<OrderItemResponseDto> mapToOrderItemResponseDto(List<OrderProducts> orderProducts) {
        return orderProducts.stream()
                .map(op -> OrderItemResponseDto.builder()
                        .productId(op.getProduct().getId())
                        .quantity(op.getQuantity())
                        .productName(op.getProduct().getTitle())
                        .productPrice(op.getProduct().getPrice())
                        .productImage(op.getProduct().getImage())
                        .subTotal(op.getProduct().getPrice().multiply(BigDecimal.valueOf(op.getQuantity())))
                        .build())
                .collect(Collectors.toList());
    }
}

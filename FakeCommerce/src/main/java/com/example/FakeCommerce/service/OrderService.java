package com.example.FakeCommerce.service;


import com.example.FakeCommerce.dtos.orders.*;
import com.example.FakeCommerce.repository.OrderProductRepository;
import com.example.FakeCommerce.repository.OrderRepository;
import com.example.FakeCommerce.repository.ProductRepository;
import com.example.FakeCommerce.schema.Order;
import com.example.FakeCommerce.schema.OrderProducts;
import com.example.FakeCommerce.schema.OrderStatus;
import com.example.FakeCommerce.schema.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;


    private OrderResponseDto mapToDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
        return mapToDto(order);
    }

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        // create order first
        Order order = Order.builder()
                .status(OrderStatus.CREATED)
                .build();
        Order savedOrder = orderRepository.save(order);

        for(OrderItemDto item : orderRequestDto.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found: " + item.getProductId()));

            OrderProducts orderProducts = OrderProducts.builder()
                    .order(savedOrder)
                    .product(product)
                    .quantity(item.getQuantity())
                    .price(product.getPrice())
                    .build();
            orderProductRepository.save(orderProducts);
        }

        return mapToDto(savedOrder);
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
        orderRepository.delete(order);
    }

    public OrderResponseDto updateOrder(Long id, UpdateOrderRequestDto updateOrderRequestDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));

        order.setStatus(updateOrderRequestDto.getStatus());
        Order savedOrder = orderRepository.save(order);
        return mapToDto(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderSummaryDto getOrderSummary(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));

        List<OrderProducts> items = orderProductRepository.findAllByOrder_Id(id);

        int totalItems = 0;
        BigDecimal totalAmount  = BigDecimal.ZERO;

        List<OrderSummaryLineDto> lines = items.stream().map(op -> {
            BigDecimal qty = BigDecimal.valueOf(op.getQuantity());
            BigDecimal lineTotal = op.getPrice().multiply(qty);

            return OrderSummaryLineDto.builder()
                    .productId(op.getProduct().getId())
                    .title(op.getProduct().getTitle())
                    .quantity(op.getQuantity())
                    .unitPrice(op.getPrice())
                    .lineTotal(lineTotal)
                    .build();
        }).toList();

        for(OrderProducts item : items) {
            totalItems += item.getQuantity();
            totalAmount = totalAmount.add(item.getPrice());
        }

        return OrderSummaryDto.builder()
                .orderId(order.getId())
                .totalItems(totalItems)
                .totalAmount(totalAmount)
                .lines(lines)
                .build();
    }
}

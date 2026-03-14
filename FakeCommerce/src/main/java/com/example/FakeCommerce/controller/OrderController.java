package com.example.FakeCommerce.controller;


import com.example.FakeCommerce.dtos.orders.OrderRequestDto;
import com.example.FakeCommerce.dtos.orders.OrderResponseDto;
import com.example.FakeCommerce.dtos.orders.OrderSummaryDto;
import com.example.FakeCommerce.dtos.orders.UpdateOrderRequestDto;
import com.example.FakeCommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

//    @GetMapping("user/{userId}")
//    public List<Order> getOrdersByUserId(@PathVariable String userId) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

    @PutMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id, @RequestBody  UpdateOrderRequestDto updateOrderRequestDto ) {
        return orderService.updateOrder(id, updateOrderRequestDto);
    }

    @GetMapping("/{id}/summary")
    public OrderSummaryDto getOrderSummary(@PathVariable Long id) {
        return orderService.getOrderSummary(id);
    }

}

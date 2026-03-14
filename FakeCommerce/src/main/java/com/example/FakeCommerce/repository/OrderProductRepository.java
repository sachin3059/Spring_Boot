package com.example.FakeCommerce.repository;

import com.example.FakeCommerce.schema.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProducts,Long> {
    boolean existsByOrder_IdAndProduct_Id(Long orderId, Long productId);
    List<OrderProducts> findAllByOrder_Id(Long orderId);
}

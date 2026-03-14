package com.example.FakeCommerce.repository;


import com.example.FakeCommerce.schema.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProduct_Id(Long productId);

    List<Review> findByOrder_Id(Long orderId);

    boolean existsByOrder_IdAndProduct_Id(Long orderId, Long productId);
}

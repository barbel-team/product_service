package com.barbel.product_service.repository;

import com.barbel.product_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<List<Order>> findOrdersByRes_tel(String tel);
}

package com.barbel.product_service.repository;

import com.barbel.product_service.entity.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    List<Order> findOrdersByRes_tel(String tel);
}


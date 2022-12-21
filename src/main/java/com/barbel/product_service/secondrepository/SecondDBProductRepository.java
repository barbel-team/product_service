package com.barbel.product_service.secondrepository;

import com.barbel.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondDBProductRepository extends JpaRepository<Product, Integer> {
}

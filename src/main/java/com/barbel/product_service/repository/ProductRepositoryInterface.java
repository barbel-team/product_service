package com.barbel.product_service.repository;


import com.barbel.product_service.entity.Product;
import com.barbel.product_service.entity.ProductImage;

public interface ProductRepositoryInterface {

  Product saveProduct(Product p);
  void saveProductImage(ProductImage productImage);
}

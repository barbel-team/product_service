package com.barbel.product_service.service;

import com.barbel.product_service.entity.Cart;
import com.barbel.product_service.entity.Product;
import com.barbel.product_service.entity.ProductImage;
import com.barbel.product_service.repository.CartRepository;
import com.barbel.product_service.repository.ProductRepository;
import com.barbel.product_service.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {

  private ProductRepositoryInterface repository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CartRepository cartRepository;
  public Product save(Product p){

    p.setPrd_name(p.getPrd_name());
    p.setPrd_price(p.getPrd_price());
    p.setPrd_cmp(p.getPrd_cmp());
    p.setPrd_type(p.getPrd_type());
    p.setPrd_ment(p.getPrd_ment());
    p.setPrd_sales(p.getPrd_sales());

    return productRepository.save(p);
  }

  public List<Cart> getMyCart(Long uid) {
   return cartRepository.findCartsByUid(uid).orElseThrow(NoSuchElementException::new);
  }

  public void uploadImage(ProductImage pi){
    repository.saveProductImage(pi);
  }

  @Autowired
  public ProductService(ProductRepositoryInterface repository){
    this.repository = repository;
  }


}
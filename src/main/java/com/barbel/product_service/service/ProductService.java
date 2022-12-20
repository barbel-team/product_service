package com.barbel.product_service.service;

import com.barbel.product_service.dto.CartResponse;
import com.barbel.product_service.entity.Cart;
import com.barbel.product_service.entity.Product;
import com.barbel.product_service.entity.ProductImage;
import com.barbel.product_service.mapper.CartResponseMapper;
import com.barbel.product_service.repository.CartRepository;
import com.barbel.product_service.repository.ProductRepository;
import com.barbel.product_service.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

  public List<CartResponse> getMyCart(Long uid) {
    List<Cart> carts = cartRepository.findCartsByUid(uid).orElseThrow(NoSuchElementException::new);
    List<CartResponse> cartResponses = new ArrayList<>();

    for(Cart cart : carts) {
      Product p = productRepository.findById(cart.getOrdnum()).orElseThrow(NoSuchElementException::new);
      cartResponses.add(CartResponseMapper.mapping(cart, p));
      System.out.println(p.getUid());
      System.out.println(cart.getUid());
    }
    return cartResponses;

  }

  public List<Product> getProduct() {
    return productRepository.findAll();
  }

  public Product getProduct(long id) {
    return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Autowired
  public ProductService(ProductRepositoryInterface repository){
    this.repository = repository;
  }


}
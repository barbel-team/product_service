package com.barbel.product_service.service;

import com.barbel.product_service.dto.CartResponse;
import com.barbel.product_service.entity.Cart;
import com.barbel.product_service.entity.Order;
import com.barbel.product_service.entity.Product;
import com.barbel.product_service.entity.ProductImage;
import com.barbel.product_service.mapper.CartResponseMapper;
import com.barbel.product_service.repository.CartRepository;
import com.barbel.product_service.repository.OrderRepository;
import com.barbel.product_service.repository.ProductRepository;
import com.barbel.product_service.repository.ProductRepositoryInterface;
import com.barbel.product_service.secondrepository.SecondDBProductRepository;
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
  private SecondDBProductRepository secondDBProductRepository;
  @Autowired
  private CartRepository cartRepository;
  @Autowired
  private OrderRepository orderRepository;
  public Product saveProduct(Product p){
    return secondDBProductRepository.save(p);
  }

  public void syncDB(){
    List<Product> list = secondDBProductRepository.findAll();
    productRepository.deleteAll();
    productRepository.saveAllAndFlush(list);
    }


  public List<CartResponse> getMyCart(Long uid) {
    List<Cart> carts = cartRepository.findCartsByUid(uid).orElseThrow(NoSuchElementException::new);
    List<CartResponse> cartResponses = new ArrayList<>();

    for(Cart cart : carts) {
      Product p = productRepository.findById((int)cart.getOrdnum()).orElseThrow(NoSuchElementException::new);
      cartResponses.add(CartResponseMapper.mapping(cart, p));
      System.out.println(p.getUid());
      System.out.println(cart.getUid());
    }
    return cartResponses;

  }

  public List<Product> getProduct() {
    return productRepository.findAll();
  }

  public Product getProduct(int id) {
    return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public Order saveOrder(Order order) {
    return orderRepository.save(order);
  }

  @Autowired
  public ProductService(ProductRepositoryInterface repository){
    this.repository = repository;
  }


}
package com.barbel.product_service.controller;

import com.barbel.product_service.entity.Order;
import com.barbel.product_service.entity.Product;
import com.barbel.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
  @Autowired
  ProductService service;

  @Autowired
  public ProductController(ProductService service) {
    this.service = service;
  }

  @PostMapping(value = "/newproduct")
  public ResponseEntity<String> createProduct(
      @Valid @RequestBody Product p
  ) {

    // product DB에 넣기
    service.saveProduct(p);

    return ResponseEntity.ok("OK");
  }
  @GetMapping(value = "/sync")
  public ResponseEntity<String> createProduct_sub() {
    service.syncDB();
    return ResponseEntity.ok("OK");
  }

  @GetMapping("/products")
  public List<Product> getProducts() {
    return service.getProduct();
  }

  @GetMapping("/product")
  public Product getProduct(@RequestParam int id) {
    return service.getProduct(id);
  }

  @PostMapping("/order")
  public ResponseEntity<String> order(@RequestBody Order order) {
    service.saveOrder(order);
    return ResponseEntity.ok("OK");
  }

  @GetMapping("/ping")
  public ResponseEntity<String> checkAlive() {
    List<Product> product = service.getProduct();
    return ResponseEntity.ok("OK");
  }

}

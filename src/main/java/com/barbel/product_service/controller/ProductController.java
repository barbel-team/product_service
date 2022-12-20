package com.barbel.product_service.controller;

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
    service.save(p);

    return ResponseEntity.ok("OK");
  }

  @GetMapping("/products")
  public List<Product> getProducts() {
    return service.getProduct();
  }

  @GetMapping("/product")
  public Product getProduct(@RequestParam long id) {
    return service.getProduct(id);
  }
}

package com.barbel.product_service.mapper;

import com.barbel.product_service.dto.ProductDTO;
import com.barbel.product_service.entity.Product;

public class ProductMapper {
  public static Product toEntity(ProductDTO productDTO) {
    return Product.builder()
        .prd_name(productDTO.getPrd_name())
        .prd_price(productDTO.getPrd_price())
        .prd_cmp(productDTO.getPrd_cmp())
        .prd_type(productDTO.getPrd_type())
        .prd_ment(productDTO.getPrd_ment())
        .prd_sales(productDTO.getPrd_sales())
            .prd_img_url(productDTO.getPrd_img_url())
            .fk_cate(productDTO.getFk_cate())
            .prd_stock(productDTO.getPrd_stock()).build();
  }
}

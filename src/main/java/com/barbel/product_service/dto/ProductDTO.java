package com.barbel.product_service.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDTO {
  @NotBlank
  private String prd_name;
  // 상품가격
  @NotBlank
  private int prd_price;
  // 상품업체
  @NotBlank
  private String prd_cmp;
  // 상품종류
  @NotBlank
  private String prd_type;
  // 상품 내용
  @NotBlank
  private String prd_ment;
  @NotBlank
  private String prd_img_url;
  @NotBlank
  private int fk_cate;
  // 판매 수량
  private int prd_sales;
  private int prd_stock;

}

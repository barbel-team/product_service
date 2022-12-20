package com.barbel.product_service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductImage {

  private String uuid;
  private long productid; //product uid
  private String imgname;
  private String contenttype;

  public ProductImage(String uuid, String imgname, String contenttype, @NotNull long productid){

    this.uuid = uuid;
    this.imgname = imgname;
    this.contenttype = contenttype;
    this.productid = productid; // product의 uid
  }

}

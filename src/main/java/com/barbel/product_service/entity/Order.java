package com.barbel.product_service.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@Entity
@DynamicInsert
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ord")
public class Order {
  @Id
  @Column(name = "uid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String res_nm;
  private String res_addr01;
  private String res_addr02;
  private String res_addr03;
  private String res_tel;
  private String deliv_req;
  private int fk_prdnum;
  private Date ord_date;
  private Time p_time;

}

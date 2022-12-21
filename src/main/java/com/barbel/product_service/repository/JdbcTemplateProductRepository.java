package com.barbel.product_service.repository;

import com.barbel.product_service.entity.Product;
import com.barbel.product_service.entity.ProductImage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateProductRepository implements ProductRepositoryInterface {

  private final JdbcTemplate jdbcTemplate;

  public JdbcTemplateProductRepository(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }


  @Override
  public Product saveProduct(Product p) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    jdbcInsert.withTableName("product").usingGeneratedKeyColumns("uid");

    // parameters 입력
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("prd_name", p.getPrd_name());
    parameters.put("prd_price", p.getPrd_price());
    parameters.put("prd_cmp", p.getPrd_cmp());
    parameters.put("prd_type", p.getPrd_type());
    parameters.put("prd_ment", p.getPrd_ment());
    parameters.put("prd_sales", p.getPrd_sales());

    // uid 설정
    Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    p.setUid(key.intValue());
    return p;

  }

  @Override
  public void saveProductImage(ProductImage pi) {
    SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
    jdbcInsert.withTableName("product_img");

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("uuid", pi.getUuid());
    parameters.put("imgname", pi.getImgname());
    parameters.put("contenttype", pi.getContenttype());
    parameters.put("productid", pi.getProductid());

    jdbcInsert.execute(parameters);
  }
}

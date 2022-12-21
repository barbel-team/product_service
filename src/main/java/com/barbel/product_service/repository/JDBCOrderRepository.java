//package com.barbel.product_service.repository;
//
//import com.barbel.product_service.entity.Order;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.List;
//
//@Repository
//public class JDBCOrderRepository implements OrderRepositoryInterface {
//    private final JdbcTemplate jdbcTemplate;
//
//    public JDBCOrderRepository(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//
//    @Override
//    public List<Order> findOrdersByRes_tel(String tel) {
//        String sql = "select * from ord where res_tel="+tel+";";
//        ResultSet rs =
//                jdbcTemplate.(sql);
//
//        return null;
//    }
//}

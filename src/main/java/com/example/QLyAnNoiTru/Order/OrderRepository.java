package com.example.QLyAnNoiTru.Order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;


@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Method to find all order
    public List<Order> findAll() {
        return jdbcTemplate.query("SELECT * FROM Orders", (rs, rowNum) -> mapRowToOrder(rs));
    }

    //Method to create a new order
    public void createOrder(Order order) {
        LocalDate currentDate = LocalDate.now();
        jdbcTemplate.update("INSERT INTO Orders(id,student_id,order_date,menu_id) VALUES (?, ?, ?,?)"
        ,order.id(),order.student_id(),currentDate,order.menu_id());
    }

    public void deleteOrder(String id) {
        jdbcTemplate.update("DELETE FROM Orders WHERE id = ?", id);
    }

    private Order mapRowToOrder(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new Order(
                rs.getString("id"),
                rs.getString("student_id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("menu_id")
        );
    }
}

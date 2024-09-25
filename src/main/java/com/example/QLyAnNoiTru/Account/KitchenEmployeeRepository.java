package com.example.QLyAnNoiTru.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KitchenEmployeeRepository {
    private static final Logger log = LoggerFactory.getLogger(KitchenEmployeeRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public KitchenEmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Method to update an account
    public void update(KitchenEmployee kitchenEmployee) {
        String sql = "UPDATE KitchenEmployees SET name = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, kitchenEmployee.getName(), kitchenEmployee.getEmail(), kitchenEmployee.getPhone(), kitchenEmployee.getId());
    }
}

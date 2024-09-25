package com.example.QLyAnNoiTru.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    private static final Logger log = LoggerFactory.getLogger(AdminRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Method to update an account
    public void update(Admin admin) {
        String sql = "UPDATE Admins SET name = ?, email = ?, phone = ? WHERE id = ?";
        jdbcTemplate.update(sql, admin.getName(), admin.getEmail(), admin.getPhone(), admin.getId());
    }
}

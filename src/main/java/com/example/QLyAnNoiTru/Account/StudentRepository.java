package com.example.QLyAnNoiTru.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private static final Logger log = LoggerFactory.getLogger(StudentRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // Method to update an account
    public void update(Student student) {
        String sql = "UPDATE Students SET full_name = ?,dob=?, email = ?, phone_number = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getFullName(), student.getDob(), student.getEmail(), student.getPhoneNumber(), student.getId());
    }
}

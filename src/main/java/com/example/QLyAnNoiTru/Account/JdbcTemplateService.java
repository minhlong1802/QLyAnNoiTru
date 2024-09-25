package com.example.QLyAnNoiTru.Account;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateService {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Object findUserDetailsByUsername(String username) {
        String sql = "SELECT student_id, admin_id, kitchen_employee_id, role FROM Accounts WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            String studentId = rs.getString("student_id");
            String adminId = rs.getString("admin_id");
            String kitchenEmployeeId = rs.getString("kitchen_employee_id");
            String role = rs.getString("role");

            if (studentId != null) {
                return findStudentById(studentId);
            } else if (adminId != null) {
                return findAdminById(adminId);
            } else if (kitchenEmployeeId != null) {
                return findKitchenEmployeeById(kitchenEmployeeId);
            } else {
                throw new IllegalArgumentException("No valid ID found for the provided username.");
            }
        }, username);
    }

    private Student findStudentById(String studentId) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Student(
                rs.getString("id"),
                rs.getString("full_name"),
                rs.getDate("dob").toLocalDate(),
                rs.getString("email"),
                rs.getString("phone_number")
        ), studentId);
    }

    private Admin findAdminById(String adminId) {
        String sql = "SELECT * FROM Admins WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Admin(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone")
        ), adminId);
    }

    private KitchenEmployee findKitchenEmployeeById(String kitchenEmployeeId) {
        String sql = "SELECT * FROM KitchenEmployees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new KitchenEmployee(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone")
        ), kitchenEmployeeId);
    }
}

package com.example.QLyAnNoiTru.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {
    private static final Logger log = LoggerFactory.getLogger(AccountRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all accounts
    public List<Account> findAll() {
        String sql = "SELECT * FROM Accounts";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToItem(rs));
    }

    // Method to create a new account
    public void create(Account account) {
        String sql = "INSERT INTO Accounts (id, username, password_hash, role, status, student_id, admin_id, kitchen_employee_id) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, account.id(),account.username(), account.password_hash(), account.role(), account.status().getCode(), account.student_id(), account.admin_id(), account.kitchen_employee_id());
    }

    // Method to update an account
    public void update(Account account) {
        String sql = "UPDATE Accounts SET username = ?, password_hash = ?, role = ?, status = ?, student_id = ?, admin_id = ?, kitchen_employee_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, account.username(), account.password_hash(), account.role(), account.status().getCode(), account.student_id(), account.admin_id(), account.kitchen_employee_id(), account.id());
    }

    // Method to delete an account
    public void delete(String id) {
        String sql = "DELETE FROM Accounts WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    // Method to find an item by id
    public Account findById(String id) {
        String sql = "SELECT * FROM Accounts WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapRowToItem(rs), id);
    }
    // Method to find an item by username
    public Account findByUsername(String username) {
        String sql = "SELECT * FROM Accounts WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapRowToItem(rs), username);
    }

    // Method to sort accounts by role
    public List<Account> findAllSortedByRole() {
        String sql = "SELECT * FROM Accounts ORDER BY role";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToItem(rs));
    }
    // Method to change the password of an account
    public void changePassword(String id, String newPasswordHash) {
        String sql = "UPDATE Accounts SET password_hash = ? WHERE id = ?";
        jdbcTemplate.update(sql, newPasswordHash, id);
    }
    private Account mapRowToItem(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new Account(
                rs.getString("id"),
                rs.getString("username"),
                rs.getString("password_hash"),
                rs.getString("role"),
                Account.Status.fromCode(rs.getInt("status")),
                rs.getString("student_id"),
                rs.getString("admin_id"),
                rs.getString("kitchen_employee_id")
        );
    }
}

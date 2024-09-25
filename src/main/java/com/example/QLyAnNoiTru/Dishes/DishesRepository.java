package com.example.QLyAnNoiTru.Dishes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishesRepository {
    private final JdbcTemplate jdbcTemplate;

    public DishesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all records
    public List<Dishes> findAll() {
        String sql = "SELECT * FROM Dishes";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToDishes(rs));
    }

    // Method to find record by ID
    public Dishes findById(String id) {
        String sql = "SELECT * FROM Dishes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> mapRowToDishes(rs));
    }

    // Method to insert new record
    public void create(Dishes dishes) {
        String sql = "INSERT INTO Dishes (id, name, image, description, category, kitchen_employee_id, position) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, dishes.id(), dishes.name(), dishes.image(), dishes.description(), dishes.category(), dishes.kitchen_employee_id(), dishes.position());
    }

    // Method to update record
    public void update(Dishes dishes) {
        String sql = "UPDATE Dishes SET name = ?, image = ?, description = ?, category = ?, kitchen_employee_id = ?, position = ? WHERE id = ?";
        jdbcTemplate.update(sql, dishes.name(), dishes.image(), dishes.description(), dishes.category(), dishes.kitchen_employee_id(), dishes.position(), dishes.id());
    }

    // Method to delete record
    public void deleteById(String id) {
        String sql = "DELETE FROM Dishes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Dishes mapRowToDishes(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new Dishes(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("image"),
                rs.getString("description"),
                rs.getString("category"),
                rs.getString("kitchen_employee_id"),
                rs.getInt("position")
        );
    }
}

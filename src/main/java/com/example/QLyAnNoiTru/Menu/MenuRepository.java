package com.example.QLyAnNoiTru.Menu;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MenuRepository {
    private final JdbcTemplate jdbcTemplate;

    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all records
    public List<Menu> findAll() {
        return jdbcTemplate.query("SELECT * FROM Menus", (rs, rowNum) -> mapRowToMenu(rs));
    }

    // Method to create a new record
    public void create(Menu menu) {
        LocalDate currentDate = LocalDate.now();
        jdbcTemplate.update("INSERT INTO Menus (id, dishes_id, date) VALUES (?, ?, ?)", menu.id(), menu.dishes_id(), currentDate);
    }

    // Method to update a record
    public void update(Menu menu) {
        jdbcTemplate.update("UPDATE Menus SET dishes_id = ?, date = ? WHERE id = ?", menu.dishes_id(), menu.date(), menu.id());
    }

    // Method to delete a record
    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM Menus WHERE id = ?", id);
    }

    private Menu mapRowToMenu(java.sql.ResultSet rs) throws java.sql.SQLException {
        return new Menu(
                rs.getString("id"),
                rs.getString("dishes_id"),
                rs.getDate("date").toLocalDate()
        );
    }
}

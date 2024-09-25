package com.example.QLyAnNoiTru.ConsumptionStatistic;

import com.example.QLyAnNoiTru.Account.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsumptionStatisticRepository {
    private static final Logger log = LoggerFactory.getLogger(ConsumptionStatisticRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public ConsumptionStatisticRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to find all accounts
    public List<ConsumptionStatistic> findAll() {
        String sql = "select * from Consumption_Statistics ";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToItem(rs));
    }
    private ConsumptionStatistic mapRowToItem(java.sql.ResultSet rs) throws java.sql.SQLException {
        Admin admin = new Admin(); // Or retrieve an Admin object as needed
        admin.setId(rs.getString("admin_id"));

        return new ConsumptionStatistic(
                rs.getString("id"),
                admin,
                rs.getDate("consumption_date").toLocalDate(),
                rs.getInt("quantity")
        );
    }
}
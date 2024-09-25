package com.example.QLyAnNoiTru.Order;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record Order(
        String id,
        String student_id,
        LocalDate order_date,
        String menu_id
) {
    public Order {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        if (student_id == null || student_id.isBlank()) {
            throw new IllegalArgumentException("student_id cannot be blank");
        }
        if (menu_id == null || menu_id.isBlank()) {
            throw new IllegalArgumentException("menu_id cannot be blank");
        }
        if (order_date == null) {
            order_date = LocalDate.now();
        }
    }
    //Function to get real time
    public static LocalDate getOrderDate(Order order) {
        return LocalDate.now();
    }
}

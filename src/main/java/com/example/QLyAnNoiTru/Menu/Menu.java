package com.example.QLyAnNoiTru.Menu;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record Menu(
        String id,
        String dishes_id,
        LocalDate date
) {
    public Menu {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        if (dishes_id == null || dishes_id.isBlank()) {
            throw new IllegalArgumentException("dishesId cannot be null or blank");
        }
        if (date == null) {
            date = LocalDate.now();
        }
    }

    // Function to get real time
    public static LocalDate getRealTime() {
        return LocalDate.now();
    }
}

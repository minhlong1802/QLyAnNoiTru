package com.example.QLyAnNoiTru.Dishes;

public record Dishes(
        String id,
        String name,
        String image,
        String description,
        String category,
        String kitchen_employee_id, // Foreign key to KitchenEmployees id.
        Integer position
) {
    public Dishes {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if (image == null || image.isBlank()) {
            throw new IllegalArgumentException("image cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("category cannot be null or blank");
        }
        if (kitchen_employee_id == null || kitchen_employee_id.isBlank()) {
            throw new IllegalArgumentException("kitchenEmployeeId cannot be null or blank");
        }
        if (position == null) {
            throw new IllegalArgumentException("position cannot be null");
        }
    }
}

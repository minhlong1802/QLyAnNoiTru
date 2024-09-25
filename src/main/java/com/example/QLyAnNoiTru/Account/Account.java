package com.example.QLyAnNoiTru.Account;

public record Account(
        String id,
        String username,
        String password_hash,
        String role,
        Status status,
        String student_id,
        String admin_id,
        String kitchen_employee_id
) {

    public Account {
        if ("Student".equals(role)) {
            if (student_id == null) throw new IllegalArgumentException("Student ID must be provided for role Student");
            admin_id = null;
            kitchen_employee_id = null;
        } else if ("Admin".equals(role)) {
            if (admin_id == null) throw new IllegalArgumentException("Admin ID must be provided for role Admin");
            student_id = null;
            kitchen_employee_id = null;
        } else if ("KitchenEmployee".equals(role)) {
            if (kitchen_employee_id == null)
                throw new IllegalArgumentException("Kitchen Employee ID must be provided for role KitchenEmployee");
            student_id = null;
            admin_id = null;
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    // Status enum nested inside the Account record
    public enum Status {
        INACTIVE(0),
        ACTIVE(1);

        private final int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        // This method returns the correct Status enum based on the code
        public static Status fromCode(int code) {
            return switch (code) {
                case 0 -> INACTIVE;
                case 1 -> ACTIVE;
                default -> throw new IllegalArgumentException("Invalid status code: " + code);
            };
        }
    }
}

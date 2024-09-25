package com.example.QLyAnNoiTru.Account;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Admins", uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Admins__AB6E616403A04EBB", columnNames = {"email"})
})
public class Admin {
    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Nationalized
    @Column(name = "name", length = 100)
    private String name;

    @Nationalized
    @Column(name = "email", length = 100)
    private String email;

    @Nationalized
    @Column(name = "phone", length = 15)
    private String phone;

    // Constructor
    public Admin(String id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Default constructor (required by JPA)
    public Admin() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

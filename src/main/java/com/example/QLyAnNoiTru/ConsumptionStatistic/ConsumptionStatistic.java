package com.example.QLyAnNoiTru.ConsumptionStatistic;

import com.example.QLyAnNoiTru.Account.Admin;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Entity
@Table(name = "Consumption_Statistics")
public class ConsumptionStatistic {

    @Id
    @Nationalized
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(name = "consumption_date")
    private LocalDate consumptionDate;

    @Column(name = "quantity")
    private Integer quantity;

    // Constructor
    public ConsumptionStatistic(String id, Admin admin, LocalDate consumptionDate, Integer quantity) {
        this.id = id;
        this.admin = admin;
        this.consumptionDate = consumptionDate;
        this.quantity = quantity;
    }

    // Default constructor (required by JPA)
    public ConsumptionStatistic() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

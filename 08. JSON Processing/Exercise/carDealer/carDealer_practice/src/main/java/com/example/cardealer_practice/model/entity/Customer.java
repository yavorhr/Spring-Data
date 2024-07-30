package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Customer extends BaseEntity{
    private String name;
    private LocalDate birthDate;
    private boolean isYoungDriver;
   private Set<Sale> sales;

    public Customer() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}

package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    private String name;
    private BigDecimal price;
    private int quantity;
    private Set<Car> cars;
    private Supplier supplier;

    public Part() {
    }

    @Column
    public String getName() {
        return name;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    @Column
    public int getQuantity() {
        return quantity;
    }

    @ManyToOne
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(mappedBy = "parts")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return quantity == part.quantity && Objects.equals(name, part.name) && Objects.equals(price, part.price) && Objects.equals(cars, part.cars) && Objects.equals(supplier, part.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, cars, supplier);
    }
}

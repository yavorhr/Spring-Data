package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Sale extends BaseEntity{
    private int discount;
    private Car car;
    private Customer customer;

    public Sale() {
    }

    @Column
    public int getDiscount() {
        return discount;
    }

    @OneToOne()
    public Car getCar() {
        return car;
    }

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

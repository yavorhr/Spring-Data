package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Sale extends BaseEntity {
  private double discount;
  private Car car;
  private Customer customer;

  public Sale() {
  }

  public double getDiscount() {
    return discount;
  }

  @OneToOne
  public Car getCar() {
    return car;
  }

  @ManyToOne
  public Customer getCustomer() {
    return customer;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}

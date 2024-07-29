package com.example.cardealer_practice.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
  private String name;
  private BigDecimal price;
  private int quantity;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
}

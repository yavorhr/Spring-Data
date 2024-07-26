package com.example.productshop_practice.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
  private String name;
  private BigDecimal price;

  private User buyer;
  private User seller;
  private Set<Category> categories;

  public Product() {
  }

  @Column
  public String getName() {
    return name;
  }

  @Column
  public BigDecimal getPrice() {
    return price;
  }

  @ManyToMany
  public Set<Category> getCategories() {
    return categories;
  }

  @ManyToOne
  public User getBuyer() {
    return buyer;
  }

  @ManyToOne
  public User getSeller() {
    return seller;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setBuyer(User buyer) {
    this.buyer = buyer;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }
}

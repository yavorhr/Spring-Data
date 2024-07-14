package com.example.springintro_practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Category extends BaseEntity {
  private String name;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  @Column(name = "categories", nullable = false, unique = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

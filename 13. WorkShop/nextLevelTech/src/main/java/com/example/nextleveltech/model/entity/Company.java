package com.example.nextleveltech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

  @Column
  private String name;

  public Company() {
  }

  @Column(nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

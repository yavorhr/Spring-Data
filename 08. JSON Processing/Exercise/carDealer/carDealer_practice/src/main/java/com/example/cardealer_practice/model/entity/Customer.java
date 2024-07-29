package com.example.cardealer_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
  private String name;
  private LocalDate birthDate;
  private boolean isYoungDriver;

  public Customer() {
  }

  @Column
  public String getName() {
    return name;
  }
  @Column(name = "birth_date")
  public LocalDate getBirthDate() {
    return birthDate;
  }
  @Column(name = "is_young_driver")
  public boolean isYoungDriver() {
    return isYoungDriver;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public void setYoungDriver(boolean youngDriver) {
    isYoungDriver = youngDriver;
  }
}

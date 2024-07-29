package com.example.cardealer_practice.model.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
  private Long id;

  public BaseEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

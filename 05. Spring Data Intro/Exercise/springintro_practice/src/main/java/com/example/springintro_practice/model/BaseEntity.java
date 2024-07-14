package com.example.springintro_practice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {
  private Long id;

  public BaseEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return thi.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

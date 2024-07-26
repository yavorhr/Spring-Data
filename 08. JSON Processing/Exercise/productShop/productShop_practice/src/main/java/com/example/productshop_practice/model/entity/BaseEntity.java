package com.example.productshop_practice.model.entity;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;


@MappedSuperclass
public class BaseEntity {
  private Long id;

  public BaseEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

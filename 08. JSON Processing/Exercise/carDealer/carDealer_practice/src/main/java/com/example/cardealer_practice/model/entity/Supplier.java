package com.example.cardealer_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
  private String name;
  private boolean isImporter;

  public Supplier() {
  }

  @Column
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "is_importer")
  public boolean isImporter() {
    return isImporter;
  }

  public void setImporter(boolean importer) {
    isImporter = importer;
  }
}

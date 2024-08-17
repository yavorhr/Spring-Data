package com.example.cardealer.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

  @Column(name = "name")
  private String name;
  @Column(name = "is_importer")
  private boolean isImporter;
  @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
  private List<Part> parts;

  public Supplier() {
    this.parts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isImporter() {
    return isImporter;
  }

  public void setImporter(boolean importer) {
    isImporter = importer;
  }

  public List<Part> getParts() {
    return parts;
  }

  public void setParts(List<Part> parts) {
    this.parts = parts;
  }
}

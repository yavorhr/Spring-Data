package com.example.cardealer_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
  private String make;
  private String model;
  private int travelledDistance;
  private Set<Part> parts;

  public Car() {
  }

  @Column
  public String getMake() {
    return make;
  }

  @Column
  public String getModel() {
    return model;
  }

  @Column(name = "travelled_distance")
  public int getTravelledDistance() {
    return travelledDistance;
  }

  @ManyToMany
  public Set<Part> getParts() {
    return parts;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setTravelledDistance(int travelledDistance) {
    this.travelledDistance = travelledDistance;
  }

  public void setParts(Set<Part> parts) {
    this.parts = parts;
  }
}

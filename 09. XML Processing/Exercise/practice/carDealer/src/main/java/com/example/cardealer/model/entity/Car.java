package com.example.cardealer.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
  @Column(name = "make", nullable = false)
  private String make;
  @Column(name = "model", nullable = false)
  private String model;
  @Column(name = "travelled_distance")
  private long travelledDistance;

  @ManyToMany(fetch = FetchType.EAGER)
  Set<Part> parts;

  public Car() {
    this.parts = new HashSet<>();
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getTravelledDistance() {
    return travelledDistance;
  }

  public void setTravelledDistance(long travelledDistance) {
    this.travelledDistance = travelledDistance;
  }

  public Set<Part> getParts() {
    return parts;
  }

  public void setParts(Set<Part> parts) {
    this.parts = parts;
  }

  public double calcCarPrice() {
    return this.parts
            .stream()
            .mapToDouble(p -> p.getPrice().doubleValue())
            .sum();
  }


}

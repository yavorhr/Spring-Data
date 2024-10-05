package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {
  private Double endurance;
  private Double passing;
  private Double shooting;

  public Stat() {
  }

  @Column(nullable = false)
  public Double getEndurance() {
    return endurance;
  }

  @Column(nullable = false)
  public Double getPassing() {
    return passing;
  }

  @Column(nullable = false)
  public Double getShooting() {
    return shooting;
  }

  public Stat setEndurance(Double endurance) {
    this.endurance = endurance;
    return this;
  }

  public Stat setPassing(Double passing) {
    this.passing = passing;
    return this;
  }

  public Stat setShooting(Double shooting) {
    this.shooting = shooting;
    return this;
  }
}

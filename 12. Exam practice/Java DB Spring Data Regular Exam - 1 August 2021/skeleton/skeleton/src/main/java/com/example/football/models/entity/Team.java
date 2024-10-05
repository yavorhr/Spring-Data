package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
  private Integer fanBase;
  private String history;
  private String name;
  private String stadiumName;
  private Town town;

  @Column(name = "fan_base", nullable = false)
  public Integer getFanBase() {
    return fanBase;
  }

  @Column(nullable = false)
  public String getHistory() {
    return history;
  }

  @Column(nullable = false, unique = true)
  public String getName() {
    return name;
  }

  @Column(nullable = false, name = "stadium_name")
  public String getStadiumName() {
    return stadiumName;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public Team setFanBase(Integer fanBase) {
    this.fanBase = fanBase;
    return this;
  }

  public Team setHistory(String history) {
    this.history = history;
    return this;
  }

  public Team setName(String name) {
    this.name = name;
    return this;
  }

  public Team setStadiumName(String stadiumName) {
    this.stadiumName = stadiumName;
    return this;
  }

  public Team setTown(Town town) {
    this.town = town;
    return this;
  }
}

package com.example.football.models.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
  private LocalDate birthDate;
  private String email;
  private String firstName;
  private String lastName;
  private PositionEnum position;
  private Stat stat;
  private Team team;
  private Town town;

  public Player() {
  }

  @Column(name = "birth_date", nullable = false)
  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Column(nullable = false, unique = true)
  public String getEmail() {
    return email;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Enumerated
  @Column(nullable = false)
  public PositionEnum getPosition() {
    return position;
  }

  @ManyToOne
  public Stat getStat() {
    return stat;
  }

  @ManyToOne
  public Team getTeam() {
    return team;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public Player setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  public Player setEmail(String email) {
    this.email = email;
    return this;
  }

  public Player setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Player setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Player setPosition(PositionEnum position) {
    this.position = position;
    return this;
  }

  public Player setStat(Stat stat) {
    this.stat = stat;
    return this;
  }

  public Player setTeam(Team team) {
    this.team = team;
    return this;
  }

  public Player setTown(Town town) {
    this.town = town;
    return this;
  }
}

package com.example.dto_exercise_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String fullName;
  private String email;
  private String password;
  private boolean isAdmin;
  private Set<Game> games;

  public User() {
  }

  public User(String fullName, String email, String password) {
    this.fullName = fullName;
    this.email = email;
    this.password = password;
    this.games = new HashSet<>();
  }

  @Column(name = "full_name", nullable = false)
  public String getFullName() {
    return fullName;
  }

  @Column(name = "email", unique = true)
  public String getEmail() {
    return email;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(name = "is_admin")
  public boolean isAdmin() {
    return isAdmin;
  }

  @ManyToMany
  public Set<Game> getGames() {
    return games;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }
}


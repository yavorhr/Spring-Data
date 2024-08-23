package com.example.nextleveltech.web.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String email;
  private String password;
  private String username;

  public User() {
  }

  @Column(unique = true)
  public String getEmail() {
    return email;
  }

  @Column(nullable = false)
  public String getPassword() {
    return password;
  }

  @Column(nullable = false, unique = true)
  public String getUsername() {
    return username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}

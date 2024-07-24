package com.example.dto_exercise.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String email;
  private String password;
  private String fullName;
  private Set<Game> games;
  private boolean isAdmin;

  public User() {
    this.games = new HashSet<>();
  }

  @ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(
          name = "users_games",
          joinColumns = @JoinColumn(name = "users_id"),
          inverseJoinColumns = @JoinColumn(name = "games_id")
  )
  public Set<Game> getGames() {
    return games;
  }

  @Column(unique = true)
  public String getEmail() {
    return email;
  }

  @Column
  public String getPassword() {
    return password;
  }

  @Column(name = "full_name")
  public String getFullName() {
    return fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }

  @Column(name = "is_admin")
  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean admin) {
    isAdmin = admin;
  }
}

package com.example.dto_exercise_practice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Order extends BaseEntity {
  private User user;
  private Set<Game> games;

  public Order() {
  }

  public Order(User user, Set<Game> games) {
    this.user = user;
    this.games = games;
  }

  @ManyToOne
  public User getUser() {
    return user;
  }

  @OneToMany
  public Set<Game> getGames() {
    return games;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setGames(Set<Game> games) {
    this.games = games;
  }
}

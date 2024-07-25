package com.example.dto_exercise.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity {
  private User user;
  private Set<Game> addedGames;

  public ShoppingCart() {
    this.addedGames = new HashSet<>();
  }

  @OneToOne(cascade = CascadeType.PERSIST)
  public User getUser() {
    return user;
  }

  @OneToMany(cascade = CascadeType.PERSIST)
  public Set<Game> getAddedGames() {
    return addedGames;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setAddedGames(Set<Game> addedGames) {
    this.addedGames = addedGames;
  }
}

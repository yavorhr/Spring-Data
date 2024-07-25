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
  private Set<Order> orders;
  private ShoppingCart shoppingCart;

  public User() {
    this.games = new HashSet<>();
    this.orders = new HashSet<>();
  }

  @OneToOne(mappedBy = "user")
  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
          name = "users_games",
          joinColumns = @JoinColumn(name = "users_id"),
          inverseJoinColumns = @JoinColumn(name = "games_id")


  )
  public Set<Game> getGames() {
    return games;
  }

  @OneToMany
  public Set<Order> getOrders() {
    return orders;
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

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }
}

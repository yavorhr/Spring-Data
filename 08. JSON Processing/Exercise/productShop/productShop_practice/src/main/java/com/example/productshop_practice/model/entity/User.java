package com.example.productshop_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private String firstName;
  private String lastName;
  private int age;
  private Set<User> friends;

  public User() {
  }

  @ManyToMany
  public Set<User> getFriends() {
    return friends;
  }

  @Column
  public int getAge() {
    return age;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setFriends(Set<User> friends) {
    this.friends = friends;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}

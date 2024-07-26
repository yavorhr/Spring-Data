package com.example.productshop_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
  private int age;
  private String firstName;
  private String lastName;

  public User() {
  }

  @Column
  public int getAge() {
    return age;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name",nullable = false)
  public String getLastName() {
    return lastName;
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

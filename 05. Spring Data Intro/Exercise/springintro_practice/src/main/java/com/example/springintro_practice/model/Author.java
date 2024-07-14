package com.example.springintro_practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
  private String firstName;
  private String lastName;

  public Author() {
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return this.firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return this.lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}

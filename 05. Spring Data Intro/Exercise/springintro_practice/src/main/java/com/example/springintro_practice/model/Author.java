package com.example.springintro_practice.model;

import jakarta.persistence.*;;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

  private String firstName;
  private String lastName;
  private Set<Book> books;

  @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
  public Set<Book> getBooks() {
    return this.books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public Author() {
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}

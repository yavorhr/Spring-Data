package com.example.springintro_practice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

  private String title;
  private String description;
  private EditionTypeEnum editionType;
  private BigDecimal price;
  private Integer copies;
  private LocalDate releaseDate;
  private AgeRestrictionEnum ageRestriction;
  private Author author;
  private Set<Category> categories;

  public Book() {
  }

  public Book(String title, String description, EditionTypeEnum editionType, BigDecimal price, Integer copies, LocalDate releaseDate, AgeRestrictionEnum ageRestriction, Author author, Set<Category> categories) {
    this.title = title;
    this.description = description;
    this.editionType = editionType;
    this.price = price;
    this.copies = copies;
    this.releaseDate = releaseDate;
    this.ageRestriction = ageRestriction;
    this.author = author;
    this.categories = categories;
  }


  @Column(name = "title", length = 50, nullable = false)
  public String getTitle() {
    return this.title;
  }

  @Column(name = "description", columnDefinition = "TEXT")
  public String getDescription() {
    return this.description;
  }

  @Enumerated(EnumType.STRING)
  @Column(name="edition_type",nullable = false)
  public EditionTypeEnum getEditionType() {
    return this.editionType;
  }

  @Column(name = "price", nullable = false)
  public BigDecimal getPrice() {
    return this.price;
  }

  @Column(name = "copies", nullable = false)
  public Integer getCopies() {
    return this.copies;
  }

  @Column(name = "release_date")
  public LocalDate getReleaseDate() {
    return this.releaseDate;
  }

  @Enumerated(EnumType.ORDINAL)
  @Column(name="age_restriction",nullable = false)
  public AgeRestrictionEnum getAgeRestriction() {
    return this.ageRestriction;
  }

  @ManyToOne
  public Author getAuthor() {
    return this.author;
  }

  @ManyToMany
  public Set<Category> getCategories() {
    return this.categories;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEditionType(EditionTypeEnum editionType) {
    this.editionType = editionType;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setCopies(Integer copies) {
    this.copies = copies;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public void setAgeRestriction(AgeRestrictionEnum ageRestriction) {
    this.ageRestriction = ageRestriction;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

}

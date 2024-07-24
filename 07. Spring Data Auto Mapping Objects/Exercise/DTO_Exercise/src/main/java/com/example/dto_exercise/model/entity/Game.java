package com.example.dto_exercise.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
  private String title;
  private String trailer;
  private String imageThumbnail;
  private Double size;
  private BigDecimal price;
  private String description;
  private LocalDate releaseDate;
  private Set<User> users;

  public Game() {
    this.users = new HashSet<>();
  }

  @ManyToMany(mappedBy = "games", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  public Set<User> getUsers() {
    return users;
  }

  public Game(String title, String trailer, String imageThumbnail, Double size, BigDecimal price, String description, LocalDate releaseDate) {
    this.title = title;
    this.trailer = trailer;
    this.imageThumbnail = imageThumbnail;
    this.size = size;
    this.price = price;
    this.description = description;
    this.releaseDate = releaseDate;
    this.users = new HashSet<>();
  }

  @Column(unique = true)
  public String getTitle() {
    return title;
  }

  @Column
  public String getTrailer() {
    return trailer;
  }

  @Column(name = "image_thumbnail")
  public String getImageThumbnail() {
    return imageThumbnail;
  }

  @Column
  public Double getSize() {
    return size;
  }

  @Column
  public BigDecimal getPrice() {
    return price;
  }

  @Column(columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @Column(name = "release_date")
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public void setImageThumbnail(String imageThumbnail) {
    this.imageThumbnail = imageThumbnail;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }


  public void setUsers(Set<User> users) {
    this.users = users;
  }
}

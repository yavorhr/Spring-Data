package com.example.dto_exercise_practice.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
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
  private String releaseDate;

  public Game() {
  }

  public Game(String title, String trailer, String imageThumbnail, Double size, BigDecimal price, String description, String releaseDate) {
    this.title = title;
    this.trailer = trailer;
    this.imageThumbnail = imageThumbnail;
    this.size = size;
    this.price = price;
    this.description = description;
    this.releaseDate = releaseDate;
  }

  @Column
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
  public String getReleaseDate() {
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

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}



package com.example.dto_exercise.model.dto;

import java.math.BigDecimal;

public class GameAddDto {
  private String title;
  private BigDecimal price;
  private Double size;
  private String trailer;
  private String thumbnail;
  private String description;
  private String releaseDate;

  public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnail, String description, String releaseDate) {
    this.title = title;
    this.price = price;
    this.size = size;
    this.trailer = trailer;
    this.thumbnail = thumbnail;
    this.description = description;
    this.releaseDate = releaseDate;
  }

  public String getTitle() {
    return title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  public String getTrailer() {
    return trailer;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public String getDescription() {
    return description;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}

package com.example.dto_exercise.model.dto.view;

import java.math.BigDecimal;

public class ViewGameDetailsDto {
  private String title;
  private BigDecimal price;
  private String description;
  private String releaseDate;

  public ViewGameDetailsDto() {
  }

  public ViewGameDetailsDto(String title, BigDecimal price, String description, String releaseDate) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.releaseDate = releaseDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }
}

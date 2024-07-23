package com.example.dto_exercise.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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

  @Pattern(regexp = "^[A-Z][a-z]{6,100}",message = "Please enter valid title!")
  public String getTitle() {
    return title;
  }

  @DecimalMin(value = "0", message = "Please enter valid price!")
  //@Min(0)
  public BigDecimal getPrice() {
    return price;
  }

  @Positive(message = "Number must be positive!")
  public Double getSize() {
    return size;
  }

  @Size(min = 11,max = 11,message = "Trailer must be 11 characters!")
  public String getTrailer() {
    return trailer;
  }

  @Pattern(regexp = "(http?).+",message = "Please enter valid URL!")
  public String getThumbnail() {
    return thumbnail;
  }

  @Size(min = 20,message = "Please enter valid description!")
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

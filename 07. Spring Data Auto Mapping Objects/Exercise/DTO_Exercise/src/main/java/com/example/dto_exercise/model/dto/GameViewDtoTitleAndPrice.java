package com.example.dto_exercise.model.dto;

import java.math.BigDecimal;

public class GameViewDtoTitleAndPrice {
  private String title;
  private BigDecimal price;

  public GameViewDtoTitleAndPrice(String title, BigDecimal price) {
    this.title = title;
    this.price = price;
  }

  public GameViewDtoTitleAndPrice() {
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
}

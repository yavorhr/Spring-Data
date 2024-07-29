package com.example.productshop_practice.model.dto.view.secondQuery;

import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

public class ProductWithNamePriceBuyerFirstAndLastNameDto {
  @Expose
  private String name;
  @Expose
  private BigDecimal price;
  @Expose
  private String buyerFirstName;
  @Expose
  private String buyerLastName;

  public ProductWithNamePriceBuyerFirstAndLastNameDto() {
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getBuyerFirstName() {
    return buyerFirstName;
  }

  public String getBuyerLastName() {
    return buyerLastName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setBuyerFirstName(String buyerFirstName) {
    this.buyerFirstName = buyerFirstName;
  }

  public void setBuyerLastName(String buyerLastName) {
    this.buyerLastName = buyerLastName;
  }
}

package com.example.productshop_practice.model.dto.view.secondQuery;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellerWithSoldProductsDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private List<ProductWithNamePriceBuyerFirstAndLastNameDto> soldProducts;

  public SellerWithSoldProductsDto() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<ProductWithNamePriceBuyerFirstAndLastNameDto> getSoldProducts() {
    return soldProducts;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setSoldProducts(List<ProductWithNamePriceBuyerFirstAndLastNameDto> soldProducts) {
    this.soldProducts = soldProducts;
  }
}

package com.example.productshop_practice.model.dto.view;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellerDtoWithSoldProducts {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private List<ProductDtoWithNamePriceBuyerFirstAndLastName> soldProducts;

  public SellerDtoWithSoldProducts() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<ProductDtoWithNamePriceBuyerFirstAndLastName> getSoldProducts() {
    return soldProducts;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setSoldProducts(List<ProductDtoWithNamePriceBuyerFirstAndLastName> soldProducts) {
    this.soldProducts = soldProducts;
  }
}

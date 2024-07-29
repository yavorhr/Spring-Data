package com.example.productshop_practice.model.dto.view.fourthQuery;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellerDataAndProductCountAndDataDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private int age;
  @Expose
  private List<ProductDto> soldProducts;

  public SellerDataAndProductCountAndDataDto() {
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<ProductDto> getSoldProducts() {
    return soldProducts;
  }

  public void setSoldProducts(List<ProductDto> soldProducts) {
    this.soldProducts = soldProducts;
  }
}

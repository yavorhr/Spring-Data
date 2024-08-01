package com.example.cardealer_practice.model.entity.dto.view;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CustomerBoughtCarsViewDto {
  @Expose()
  @SerializedName("fullName")
  private String name;
  @Expose
  private int boughtCars;
  @Expose
  private BigDecimal spentMoney;

  public CustomerBoughtCarsViewDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBoughtCars() {
    return boughtCars;
  }

  public void setBoughtCars(int boughtCars) {
    this.boughtCars = boughtCars;
  }

  public BigDecimal getSpentMoney() {
    return spentMoney;
  }

  public void setSpentMoney(BigDecimal spentMoney) {
    this.spentMoney = spentMoney;
  }
}

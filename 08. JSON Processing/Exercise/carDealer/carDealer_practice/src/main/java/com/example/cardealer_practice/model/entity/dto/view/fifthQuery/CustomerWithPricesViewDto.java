package com.example.cardealer_practice.model.entity.dto.view.fifthQuery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerWithPricesViewDto {
  @Expose
  private CarViewDto car;
  @Expose
  @SerializedName("customerName")
  private String name;
  @Expose
  private double discount;
  @Expose
  private double price;
  @Expose
  private double priceWithDiscount;

  public CustomerWithPricesViewDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPriceWithDiscount() {
    return priceWithDiscount;
  }

  public void setPriceWithDiscount(double priceWithDiscount) {
    this.priceWithDiscount = priceWithDiscount;
  }

  public CarViewDto getCar() {
    return car;
  }

  public void setCar(CarViewDto car) {
    this.car = car;
  }
}

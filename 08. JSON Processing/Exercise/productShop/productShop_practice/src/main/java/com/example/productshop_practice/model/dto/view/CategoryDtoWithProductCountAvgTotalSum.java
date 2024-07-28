package com.example.productshop_practice.model.dto.view;

import com.google.gson.annotations.Expose;

public class CategoryDtoWithProductCountAvgTotalSum {
  @Expose
  private String category;
  @Expose
  private long productsCount;
  @Expose
  private double averagePrice;
  @Expose
  private double totalRevenue;

  public CategoryDtoWithProductCountAvgTotalSum() {
  }

  public void setAveragePrice(double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public String getCategory() {
    return category;
  }

  public long getProductsCount() {
    return productsCount;
  }

  public double getAveragePrice() {
    return averagePrice;
  }

  public double getTotalRevenue() {
    return totalRevenue;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setProductsCount(long productsCount) {
    this.productsCount = productsCount;
  }
}

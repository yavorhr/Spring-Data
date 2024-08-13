package com.example.shop.model.dto.view.ThirdQuery;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewDto {

  @XmlAttribute(name = "name")
  private String name;
  @XmlElement(name = "products-count")
  private long productsCount;
  @XmlElement(name = "average-price")
  private double averagePrice;
  @XmlElement(name = "total-revenue")
  private int totalRevenue;

  public long getProductsCount() {
    return productsCount;
  }

  public void setProductsCount(long productsCount) {
    this.productsCount = productsCount;
  }

  public double getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public int getTotalRevenue() {
    return totalRevenue;
  }

  public void setTotalRevenue(int totalRevenue) {
    this.totalRevenue = totalRevenue;
  }
}

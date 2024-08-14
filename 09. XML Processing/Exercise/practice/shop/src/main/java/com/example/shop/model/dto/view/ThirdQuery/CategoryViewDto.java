package com.example.shop.model.dto.view.ThirdQuery;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewDto {

  @XmlAttribute(name = "name")
  private String name;
  @XmlElement(name = "products-count")
  private int productsCount;
  @XmlElement(name = "average-price")
  private double averagePrice;
  @XmlElement(name = "total-revenue")
  private double totalRevenue;

  public int getProductsCount() {
    return productsCount;
  }

  public String getName() {
    return name;
  }

  public void setProductsCount(Integer productsCount) {
    this.productsCount = productsCount;
  }

  public void setAveragePrice(double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public void setTotalRevenue(double totalRevenue) {
    this.totalRevenue = totalRevenue;
  }

  public void setName(String name) {
    this.name = name;
  }
}

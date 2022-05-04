package com.example.xmlexercise.model.dto.Shop_query3;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWithProductDetailsDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "products-count")
    int productsCount;
    @XmlElement(name = "average-price")
    double averagePrice;
    @XmlElement(name = "total-revenue")
    double totalRevenue ;

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

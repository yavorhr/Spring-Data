package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDto {

    @XmlElement(name = "car")
    private SalesCarsDro salesCarsDro;
    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement(name = "discount")
    private BigDecimal discount;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleDto() {
    }

    public SalesCarsDro getSalesCarsDro() {
        return salesCarsDro;
    }

    public void setSalesCarsDro(SalesCarsDro salesCarsDro) {
        this.salesCarsDro = salesCarsDro;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}

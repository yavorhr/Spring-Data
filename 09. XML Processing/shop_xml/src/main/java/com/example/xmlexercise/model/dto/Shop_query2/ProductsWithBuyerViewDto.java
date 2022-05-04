package com.example.xmlexercise.model.dto.Shop_query2;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product" )
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsWithBuyerViewDto {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;
    //
    private String buyerLastName;

    public ProductsWithBuyerViewDto() {
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }
}

package com.example.shop.model.dto.view.SecondQuery;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsWithBuyerViewDto {

  @XmlElement
  private String name;
  @XmlElement
  private BigDecimal price;
  @XmlAttribute(name = "buyer-first-name")
  private String buyerFirstName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getBuyerFirstName() {
    return buyerFirstName;
  }

  public void setBuyerFirstName(String buyerFirstName) {
    this.buyerFirstName = buyerFirstName;
  }
}

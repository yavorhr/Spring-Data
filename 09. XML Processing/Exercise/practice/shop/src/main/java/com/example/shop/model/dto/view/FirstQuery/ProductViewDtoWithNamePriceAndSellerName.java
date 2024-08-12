package com.example.shop.model.dto.view.FirstQuery;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewDtoWithNamePriceAndSellerName {

  @XmlAttribute(name = "name")
  private String name;
  @XmlAttribute(name = "price")
  private BigDecimal price;
  @XmlAttribute(name = "seller")
  private String seller;

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getSeller() {
    return seller;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }
}

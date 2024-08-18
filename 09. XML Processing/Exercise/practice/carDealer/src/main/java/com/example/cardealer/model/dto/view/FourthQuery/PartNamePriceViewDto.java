package com.example.cardealer.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartNamePriceViewDto {
  @XmlAttribute
  private String name;
  @XmlAttribute
  private BigDecimal price;

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}

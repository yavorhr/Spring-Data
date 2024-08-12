package com.example.shop.model.dto.seed;

import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto {

  @XmlElement
  private String name;
  @XmlElement
  private BigDecimal price;

  @Size(min = 3)
  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }
}

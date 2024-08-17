package com.example.cardealer.model.dto.seed;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartNamePriceQuantityDto {

  @XmlAttribute
  private String name;
  @XmlAttribute
  private BigDecimal price;
  @XmlAttribute
  private int quantity;

  @Size(min = 2)
  public String getName() {
    return name;
  }

  @Positive
  public BigDecimal getPrice() {
    return price;
  }

  @Positive
  public int getQuantity() {
    return quantity;
  }
}

package com.example.cardealer.model.dto.view.FifthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerFullNameCountCarsMoneySpentViewDto {

  @XmlAttribute
  private String fullName;
  @XmlAttribute
  private int boughtCars;
  @XmlAttribute
  private BigDecimal spentMoney;

  public String getFullName() {
    return fullName;
  }

  public int getBoughtCars() {
    return boughtCars;
  }

  public BigDecimal getSpentMoney() {
    return spentMoney;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setBoughtCars(int boughtCars) {
    this.boughtCars = boughtCars;
  }

  public void setSpentMoney(BigDecimal spentMoney) {
    this.spentMoney = spentMoney;
  }
}

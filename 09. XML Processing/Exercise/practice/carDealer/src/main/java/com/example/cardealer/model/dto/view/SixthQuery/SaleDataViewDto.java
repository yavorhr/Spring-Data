package com.example.cardealer.model.dto.view.SixthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDataViewDto {

  @XmlElement
  private CarInfoViewDto car;
  @XmlElement
  private String customerName;
  @XmlElement
  private double discount;

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public CarInfoViewDto getCar() {
    return car;
  }

  public void setCar(CarInfoViewDto car) {
    this.car = car;
  }
}

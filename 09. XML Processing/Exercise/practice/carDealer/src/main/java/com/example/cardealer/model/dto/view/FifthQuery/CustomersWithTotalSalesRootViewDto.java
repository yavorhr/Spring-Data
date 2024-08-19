package com.example.cardealer.model.dto.view.FifthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersWithTotalSalesRootViewDto {

  @XmlElement(name = "customer")
  private List<CustomerFullNameCountCarsMoneySpentViewDto> customers;

  public void setCustomers(List<CustomerFullNameCountCarsMoneySpentViewDto> customers) {
    this.customers = customers;
  }
}

package com.example.cardealer.model.dto.view.FirstQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersRootDto {

  @XmlElement(name = "customer")
  private List<CustomerIdNameBdayIsYoungDriverDto> customers;

  public void setCustomers(List<CustomerIdNameBdayIsYoungDriverDto> customers) {
    this.customers = customers;
  }
}

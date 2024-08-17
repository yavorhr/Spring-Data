package com.example.cardealer.model.dto.seed;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersRootDto {

  @XmlElement(name = "customer")
  private List<CustomerNameBdayYoungDriverDto> customers;

  public List<CustomerNameBdayYoungDriverDto> getCustomers() {
    return customers;
  }
}

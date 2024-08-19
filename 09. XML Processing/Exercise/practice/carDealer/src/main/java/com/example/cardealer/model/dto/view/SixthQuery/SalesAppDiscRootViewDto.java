package com.example.cardealer.model.dto.view.SixthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesAppDiscRootViewDto {

  @XmlElement(name = "sale")
  private List<SaleDataViewDto> sales;

  public void setSales(List<SaleDataViewDto> sales) {
    this.sales = sales;
  }
}

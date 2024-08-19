package com.example.cardealer.model.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierRootDto {

  @XmlElement(name = "supplier")
  private List<SupplierNameIsImporterDto> suppliers;

  public List<SupplierNameIsImporterDto> getSuppliers() {
    return suppliers;
  }
}

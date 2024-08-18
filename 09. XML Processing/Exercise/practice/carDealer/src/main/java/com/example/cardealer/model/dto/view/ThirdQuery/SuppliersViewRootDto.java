package com.example.cardealer.model.dto.view.ThirdQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersViewRootDto {

  @XmlElement(name = "supplier")
  List<SupplierIdNamePartsCountViewDto> suppliers;

  public void setSuppliers(List<SupplierIdNamePartsCountViewDto> suppliers) {
    this.suppliers = suppliers;
  }
}

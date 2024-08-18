package com.example.cardealer.model.dto.view.ThirdQuery;

import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierIdNamePartsCountViewDto {

  @XmlAttribute
  private long id;
  @XmlAttribute
  private String name;
  @XmlAttribute(name = "parts-count")
  private int partsCount;

  public long getId() {
    return id;
  }

  @Size(min = 1)
  public String getName() {
    return name;
  }

  public int getPartsCount() {
    return partsCount;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPartsCount(int partsCount) {
    this.partsCount = partsCount;
  }
}

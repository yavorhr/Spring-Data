package com.example.cardealer.model.dto.seed;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierNameIsImporterDto {

  @XmlAttribute(name = "name")
  private String name;
  @XmlAttribute(name = "is-importer")
  private boolean isImported;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isImported() {
    return isImported;
  }

  public void setImported(boolean imported) {
    isImported = imported;
  }
}

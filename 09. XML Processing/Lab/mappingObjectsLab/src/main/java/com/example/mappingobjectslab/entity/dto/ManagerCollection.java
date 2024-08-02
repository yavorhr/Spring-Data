package com.example.mappingobjectslab.entity.dto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "managers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerCollection {

  @XmlElement(name = "manager")
  private List<ManagerDto> managers;

  public ManagerCollection(List<ManagerDto> managers) {
    this.managers = managers;
  }

  public ManagerCollection() {
  }

  public List<ManagerDto> getManagers() {
    return managers;
  }

  public void setManagers(List<ManagerDto> managers) {
    this.managers = managers;
  }
}

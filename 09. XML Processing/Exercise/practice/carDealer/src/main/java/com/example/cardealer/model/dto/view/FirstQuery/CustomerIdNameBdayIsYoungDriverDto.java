package com.example.cardealer.model.dto.view.FirstQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerIdNameBdayIsYoungDriverDto {

  private long id;
  private String name;
  private LocalDateTime birthDate;
  private boolean isYoungDriver;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDateTime birthDate) {
    this.birthDate = birthDate;
  }

  public boolean isYoungDriver() {
    return isYoungDriver;
  }

  public void setYoungDriver(boolean youngDriver) {
    isYoungDriver = youngDriver;
  }
}

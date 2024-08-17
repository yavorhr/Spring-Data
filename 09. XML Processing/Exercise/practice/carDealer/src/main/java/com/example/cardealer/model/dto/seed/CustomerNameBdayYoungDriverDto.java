package com.example.cardealer.model.dto.seed;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerNameBdayYoungDriverDto {

  @XmlAttribute
  private String name;
  @XmlElement(name = "birth-date")
  private String birthDate;
  @XmlElement(name = "is-young-driver")
  private boolean isYoungDriver;

  public String getName() {
    return name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public boolean isYoungDriver() {
    return isYoungDriver;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public void setYoungDriver(boolean youngDriver) {
    isYoungDriver = youngDriver;
  }
}

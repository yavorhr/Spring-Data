package com.example.cardealer.model.dto.view.SixthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarInfoViewDto {

  @XmlAttribute
  private String make;
  @XmlAttribute
  private String model;
  @XmlAttribute(name = "travelled-distance")
  private long travelledDistance;

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getTravelledDistance() {
    return travelledDistance;
  }

  public void setTravelledDistance(long travelledDistance) {
    this.travelledDistance = travelledDistance;
  }
}

package com.example.cardealer.model.dto.seed;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelDistanceDto {

  @XmlElement
  private String make;
  @XmlElement
  private String model;
  @XmlElement(name = "travelled-distance")
  private long travelledDistance;

  @Size(min = 2)
  public String getMake() {
    return make;
  }

  @Positive
  public long getTravelledDistance() {
    return travelledDistance;
  }

  @Size(min = 2)
  public String getModel() {
    return model;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setTravelledDistance(long travelledDistance) {
    this.travelledDistance = travelledDistance;
  }
}

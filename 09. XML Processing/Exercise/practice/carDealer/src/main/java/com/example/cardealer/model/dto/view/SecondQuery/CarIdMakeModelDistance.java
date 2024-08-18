package com.example.cardealer.model.dto.view.SecondQuery;

import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarIdMakeModelDistance {

  @XmlAttribute
  private long id;
  @XmlAttribute
  private String make;
  @XmlAttribute
  private String model;
  @XmlAttribute(name = "travelled-distance")
  private int travelledDistance;

  public long getId() {
    return id;
  }

  @Size(min = 1)
  public String getMake() {
    return make;
  }

  @Size(min = 1)
  public String getModel() {
    return model;
  }

  public int getTravelledDistance() {
    return travelledDistance;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setTravelledDistance(int travelledDistance) {
    this.travelledDistance = travelledDistance;
  }
}

package com.example.cardealer.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelDistanceViewDto {

  @XmlAttribute
  private String make;
  @XmlAttribute
  private String model;
  @XmlAttribute(name = "travelled-distance")
  private long travelledDistance;

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  private List<PartNamePriceViewDto> parts;

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public long getTravelledDistance() {
    return travelledDistance;
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

  public List<PartNamePriceViewDto> getParts() {
    return parts;
  }

  public void setParts(List<PartNamePriceViewDto> parts) {
    this.parts = parts;
  }
}

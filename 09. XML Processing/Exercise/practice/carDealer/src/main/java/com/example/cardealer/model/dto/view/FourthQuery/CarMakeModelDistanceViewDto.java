package com.example.cardealer.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarMakeModelDistanceViewDto {

  @XmlAttribute
  private String name;
  @XmlAttribute
  private String model;
  @XmlAttribute(name = "travelled-distance")
  private long travelledDistance;

  @XmlElementWrapper(name = "parts")
  @XmlElement(name = "part")
  private List<PartNamePriceViewDto> parts;

  public String getName() {
    return name;
  }

  public String getModel() {
    return model;
  }

  public long getTravelledDistance() {
    return travelledDistance;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setTravelledDistance(long travelledDistance) {
    this.travelledDistance = travelledDistance;
  }
}

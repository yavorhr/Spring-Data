package com.example.cardealer.model.dto.seed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootDto {

  @XmlElement(name = "car")
  List<CarMakeModelDistanceDto> cars;

  public List<CarMakeModelDistanceDto> getCars() {
    return cars;
  }
}

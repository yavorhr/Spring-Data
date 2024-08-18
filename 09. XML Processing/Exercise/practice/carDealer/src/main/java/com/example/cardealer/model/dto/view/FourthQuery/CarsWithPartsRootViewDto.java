package com.example.cardealer.model.dto.view.FourthQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsWithPartsRootViewDto {

  @XmlElement(name = "car")
  List<CarMakeModelDistanceViewDto> cars;

  public void setCars(List<CarMakeModelDistanceViewDto> cars) {
    this.cars = cars;
  }
}

package com.example.cardealer.model.dto.view.SecondQuery;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsRootViewDto {

  private List<CarIdMakeModelDistance> cars;

  public void setCars(List<CarIdMakeModelDistance> cars) {
    this.cars = cars;
  }
}


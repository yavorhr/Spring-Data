package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsPartsDto {

    @XmlElement(name = "car")
    private List<CarsDto> cars;

    public CarsPartsDto() {
    }

    public List<CarsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarsDto> cars) {
        this.cars = cars;
    }
}

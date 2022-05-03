package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarFromToyotaRootDto {

    @XmlElement(name = "car")
    private List<CarFromToyotaDto> cars;

    public CarFromToyotaRootDto() {
    }

    public List<CarFromToyotaDto> getCars() {
        return cars;
    }

    public void setCars(List<CarFromToyotaDto> cars) {
        this.cars = cars;
    }
}

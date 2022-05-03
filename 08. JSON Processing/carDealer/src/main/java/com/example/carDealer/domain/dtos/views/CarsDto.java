package com.example.carDealer.domain.dtos.views;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsDto {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "traveled-distance")
    private long travelledDistance;
    @XmlElement(name = "parts")
    private RootPartDto partDto;


    public CarsDto() {
    }

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

    public RootPartDto getPartDto() {
        return partDto;
    }

    public void setPartDto(RootPartDto partDto) {
        this.partDto = partDto;
    }
}

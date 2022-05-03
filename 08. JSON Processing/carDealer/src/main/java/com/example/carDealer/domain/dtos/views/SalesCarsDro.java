package com.example.carDealer.domain.dtos.views;

import javax.xml.bind.annotation.*;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesCarsDro {

    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute()
    private long travelledDistance;



    public SalesCarsDro() {
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
}

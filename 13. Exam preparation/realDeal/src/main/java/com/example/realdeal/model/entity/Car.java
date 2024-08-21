package com.example.realdeal.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private Integer kilometers;
    private LocalDate registeredOn;
    private Set<Picture> pictures;

    public Car() {
    }

    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @Column(name = "make", length = 19)
    public String getMake() {
        return make;
    }
    @Column(name = "model", length = 19)
    public String getModel() {
        return model;
    }
    @Column(name = "kilometers")
    public Integer getKilometers() {
        return kilometers;
    }
    @Column(name = "registered_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }
}

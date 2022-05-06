package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

    private String name;
    private int population;
    private String travelGuide;

    public Town() {
    }

    @Column(name = "name",unique = true,nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "population",nullable = false)
    public int getPopulation() {
        return population;
    }
    @Column(name = "travel_guide",columnDefinition = "TEXT",nullable = false)
    public String getTravelGuide() {
        return travelGuide;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}

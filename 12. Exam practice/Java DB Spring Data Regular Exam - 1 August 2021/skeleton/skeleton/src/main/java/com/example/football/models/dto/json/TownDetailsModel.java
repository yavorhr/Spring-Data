package com.example.football.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownDetailsModel {
  @Expose
  private String name;
  @Expose
  private Integer population;
  @Expose
  private String travelGuide;

  public TownDetailsModel() {
  }

  @Size(min = 2)
  public String getName() {
    return name;
  }

  @Positive
  public Integer getPopulation() {
    return population;
  }

  @Size(min = 10)
  public String getTravelGuide() {
    return travelGuide;
  }

  public TownDetailsModel setName(String name) {
    this.name = name;
    return this;
  }

  public TownDetailsModel setPopulation(Integer population) {
    this.population = population;
    return this;
  }

  public TownDetailsModel setTravelGuide(String travelGuide) {
    this.travelGuide = travelGuide;
    return this;
  }
}

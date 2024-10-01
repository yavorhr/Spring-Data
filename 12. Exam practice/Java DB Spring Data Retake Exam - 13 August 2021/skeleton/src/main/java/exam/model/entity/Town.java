package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
  private String name;
  private Integer population;
  private String travelGuide;

  public Town() {
  }

  @Column(unique = true, nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public Integer getPopulation() {
    return population;
  }

  @Column(columnDefinition = "TEXT", nullable = false)
  public String getTravelGuide() {
    return travelGuide;
  }

  public Town setName(String name) {
    this.name = name;
    return this;
  }

  public Town setPopulation(Integer population) {
    this.population = population;
    return this;
  }

  public Town setTravelGuide(String travelGuide) {
    this.travelGuide = travelGuide;
    return this;
  }
}

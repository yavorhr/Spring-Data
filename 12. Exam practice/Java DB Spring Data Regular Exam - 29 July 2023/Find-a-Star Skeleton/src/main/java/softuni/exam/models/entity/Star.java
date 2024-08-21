package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

  private String name;
  private double lightYears;
  private String description;
  private StarTypeEnum startType;
  private Set<Observer> observers;

  public Star() {
  }

  @Column(length = 30, unique = true)
  public String getName() {
    return name;
  }

  @Column
  public double getLightYears() {
    return lightYears;
  }

  @Column(columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }
  @Enumerated(EnumType.STRING)
  public StarTypeEnum getStartType() {
    return startType;
  }

  public Set<Observer> getObservers() {
    return observers;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLightYears(double lightYears) {
    this.lightYears = lightYears;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartType(StarTypeEnum startType) {
    this.startType = startType;
  }

  public void setObservers(Set<Observer> observers) {
    this.observers = observers;
  }
}

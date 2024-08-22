package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {
  private String name;
  private Double lightYears;
  private String description;
  private StarTypeEnum starType;
  private Constellation constellation;
  private Set<Astronomer> observers;

  public Star() {
  }

  @OneToMany(mappedBy = "observingStar", fetch = FetchType.EAGER)
  public Set<Astronomer> getObservers() {
    return observers;
  }

  @ManyToOne
  public Constellation getConstellation() {
    return constellation;
  }

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public StarTypeEnum getStarType() {
    return starType;
  }

  @Column(unique = true, nullable = false)
  public String getName() {
    return name;
  }


  @Column(nullable = false)
  public Double getLightYears() {
    return lightYears;
  }

  @Column(columnDefinition = "TEXT", nullable = false)
  public String getDescription() {
    return description;
  }

  public Star setDescription(String description) {
    this.description = description;
    return this;
  }

  public void setConstellation(Constellation constellation) {
    this.constellation = constellation;
  }

  public void setObservers(Set<Astronomer> observers) {
    this.observers = observers;
  }

  public Star setStarType(StarTypeEnum dayOfWeek) {
    this.starType = dayOfWeek;
    return this;
  }

  public Star setLightYears(Double distanceLightYears) {
    this.lightYears = distanceLightYears;
    return this;
  }

  public Star setName(String cityName) {
    this.name = cityName;
    return this;
  }

}

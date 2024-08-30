package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

  private String townName;
  private int population;

  public Town() {
  }

  @Column(nullable = false, unique = true)
  public String getTownName() {
    return townName;
  }

  @Column(nullable = false)
  public int getPopulation() {
    return population;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public void setPopulation(int population) {
    this.population = population;
  }
}

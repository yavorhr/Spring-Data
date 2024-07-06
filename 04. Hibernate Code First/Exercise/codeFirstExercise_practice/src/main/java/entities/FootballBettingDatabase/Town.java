package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
  private String name;
  private Country country;

  public Town(Country country, String name) {
    this.country = country;
    this.name = name;
  }

  public Town() {
  }

  @ManyToOne
  public Country getCountry() {
    return this.country;
  }

  public String getName() {
    return this.name;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public void setName(String name) {
    this.name = name;
  }
}

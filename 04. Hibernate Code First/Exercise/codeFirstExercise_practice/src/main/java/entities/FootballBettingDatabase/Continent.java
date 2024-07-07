package entities.FootballBettingDatabase;


import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity {
  private String name;
  private Set<Country> country;

  public Continent() {
  }

  @ManyToMany(mappedBy = "continents")
  public Set<Country> getCountries() {
    return this.country;
  }

  public void setCountries(Set<Country> countries) {
    this.country = countries;
  }

  public Continent(String name) {
    this.name = name;
  }

  @Column(name = "name", nullable = false, unique = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

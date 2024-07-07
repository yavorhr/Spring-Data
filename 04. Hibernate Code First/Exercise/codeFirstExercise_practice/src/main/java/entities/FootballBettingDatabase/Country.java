package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
  private String name;
  private Set<Continent> continent;

  public Country() {
  }

  @ManyToMany
  public Set<Continent> getContinents() {
    return this.continent;
  }

  public void setContinents(Set<Continent> continent) {
    this.continent = continent;
  }

  public Country(String name) {
    this.name = name;
  }

  @Column(name = "name", nullable = false,unique = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

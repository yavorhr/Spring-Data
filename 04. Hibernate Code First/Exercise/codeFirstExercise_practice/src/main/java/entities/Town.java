package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "towns")
public class Town extends BaseEntityWithName {
  private Country country;

  public Town(Country country) {
    this.country = country;
  }

  public Town() {
  }

  @ManyToOne
  public Country getCountry() {
    return this.country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}

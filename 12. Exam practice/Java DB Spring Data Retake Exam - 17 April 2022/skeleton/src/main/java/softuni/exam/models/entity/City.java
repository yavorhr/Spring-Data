package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {
  private String cityName;
  private String description;
  private Integer population;
  private Country country;

  public City() {
  }

  @Column(name = "city_name", nullable = false, unique = true)
  public String getCityName() {
    return cityName;
  }

  @Column(columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @Column(nullable = false)
  public Integer getPopulation() {
    return population;
  }

  @ManyToOne
  public Country getCountry() {
    return country;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}

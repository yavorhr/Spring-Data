package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

  private String countryName;
  private String currency;

  public Country() {
  }

  @Column(name = "country_name", nullable = false, unique = true)
  public String getCountryName() {
    return countryName;
  }

  @Column(nullable = false)
  public String getCurrency() {
    return currency;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

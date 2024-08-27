package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {
  private String name;
  private String website;
  private LocalDate dateEstablished;
  private Country country;

  public Company() {
  }

  @ManyToOne
  public Country getCountry() {
    return country;
  }

  @Column(unique = true, nullable = false)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public String getWebsite() {
    return website;
  }

  @Column(nullable = false, name = "date_established")
  public LocalDate getDateEstablished() {
    return dateEstablished;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public void setDateEstablished(LocalDate dateEstablished) {
    this.dateEstablished = dateEstablished;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

}


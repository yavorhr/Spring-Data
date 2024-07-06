package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
  private String name;

  public Country() {
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

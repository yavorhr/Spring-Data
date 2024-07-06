package entities;

import javax.persistence.Column;
import javax.persistence.Table;

@Table
@Column(name = "countries")
public class Country extends BaseEntity {
  private String name;

  public Country(String name) {
    this.name = name;
  }

  public Country() {
  }

  @Column(name = "name", unique = true, nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

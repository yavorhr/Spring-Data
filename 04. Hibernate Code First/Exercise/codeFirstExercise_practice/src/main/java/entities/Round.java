package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity {
  private String name;

  public Round(String name) {
    this.name = name;
  }

  public Round() {
  }

  @Column(name = "name")
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

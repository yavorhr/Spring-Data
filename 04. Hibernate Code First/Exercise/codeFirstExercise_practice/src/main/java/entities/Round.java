package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rounds")
public class Round extends BaseEntity {
  private String name;

  public Round() {
  }

  public Round(String name) {
    this.name = name;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

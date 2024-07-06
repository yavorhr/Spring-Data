package entities.FootballBettingDatabase;
import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
  private String name;

  public Color(String name) {
    this.name = name;
  }

  public Color() {
  }

  @Column(name = "name", nullable = false,unique = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
  private String name;

  public Color() {
  }

  public Color(String name) {
    this.name = name;
  }

  @Column(name = "name", unique = true,nullable = false)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

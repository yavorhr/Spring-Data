package entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntityWithName extends BaseEntity {
  private String name;

  public BaseEntityWithName() {
  }

  @Column(name = "name", nullable = false, unique = true)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

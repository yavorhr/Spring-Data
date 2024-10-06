package softuni.exam.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    private String name;
    private Picture picture;

  public Team() {
  }

  @Column(unique = true, nullable = false)
  public String getName() {
    return name;
  }

  @ManyToOne
  public Picture getPicture() {
    return picture;
  }

  public Team setName(String name) {
    this.name = name;
    return this;
  }

  public Team setPicture(Picture picture) {
    this.picture = picture;
    return this;
  }
}

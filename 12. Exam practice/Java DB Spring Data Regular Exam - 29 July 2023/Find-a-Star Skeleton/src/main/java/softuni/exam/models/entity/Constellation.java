package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity {
  private String name;
  private String description;
  private Set<Star> stars;

  public Constellation() {
  }

  @OneToMany(mappedBy = "constellation",fetch = FetchType.EAGER)
  public Set<Star> getStars() {
    return stars;
  }

  @Column(length = 20, unique = true, nullable = false)
  public String getName() {
    return name;
  }

  @Column(columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }


  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStars(Set<Star> stars) {
    this.stars = stars;
  }
}

package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity {

  private String name;
  private String description;
  private Set<Star> stars;

  public Constellation() {
  }

  @Column(length = 20, unique = true)
  public String getName() {
    return name;
  }

  @Column(columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @OneToMany
  public Set<Star> getStars() {
    return stars;
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

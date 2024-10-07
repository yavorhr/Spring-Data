package softuni.exam.domain.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
  private String name;
  private Picture picture;
  private List<Player> players;

  public Team() {
  }

  @OneToMany(mappedBy = "team")
  public List<Player> getPlayers() {
    return players;
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

  public Team setPlayers(List<Player> players) {
    this.players = players;
    return this;
  }
}

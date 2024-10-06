package softuni.exam.domain.entities;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
  private String firstName;
  private String lastName;
  private Integer number;
  private BigDecimal salary;
  private PositionEnum position;
  private Picture picture;
  private Team team;

  public Player() {
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(nullable = false)
  public Integer getNumber() {
    return number;
  }

  @Column(nullable = false)
  public BigDecimal getSalary() {
    return salary;
  }

  @Enumerated(EnumType.STRING)
  public PositionEnum getPosition() {
    return position;
  }

  @ManyToOne
  public Picture getPicture() {
    return picture;
  }

  @ManyToOne
  public Team getTeam() {
    return team;
  }

  public Player setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Player setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Player setNumber(Integer number) {
    this.number = number;
    return this;
  }

  public Player setSalary(BigDecimal price) {
    this.salary = price;
    return this;
  }

  public Player setPosition(PositionEnum position) {
    this.position = position;
    return this;
  }

  public Player setPicture(Picture picture) {
    this.picture = picture;
    return this;
  }

  public Player setTeam(Team team) {
    this.team = team;
    return this;
  }
}

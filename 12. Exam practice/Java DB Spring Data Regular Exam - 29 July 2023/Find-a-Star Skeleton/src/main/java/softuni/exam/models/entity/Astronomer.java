package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {
  private String firstName;
  private String lastName;
  private double salary;
  private double averageObservationHours;
  private LocalDate birthday;
  private Star observingStar;

  public Astronomer() {
  }

  @ManyToOne
  public Star getObservingStar() {
    return observingStar;
  }

  @Column(name = "first_name", length = 30, nullable = false)
  public String getFirstName() {
    return firstName;
  }
  @Column(name = "last_name", length = 30)
  public String getLastName() {
    return lastName;
  }
  @Column
  public double getSalary() {
    return salary;
  }
  @Column(name = "average_observation_hours")
  public double getAverageObservationHours() {
    return averageObservationHours;
  }
  @Column
  public LocalDate getBirthday() {
    return birthday;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public void setAverageObservationHours(double averageObservationHours) {
    this.averageObservationHours = averageObservationHours;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public void setObservingStar(Star observingStar) {
    this.observingStar = observingStar;
  }
}

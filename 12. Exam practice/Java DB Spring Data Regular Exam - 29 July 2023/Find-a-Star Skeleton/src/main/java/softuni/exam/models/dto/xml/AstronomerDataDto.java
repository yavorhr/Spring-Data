package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.Star;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerDataDto {

  @XmlElement(name = "average_observation_hours")
  private double averageObservationHours;
  @XmlElement
  private String birthday;
  @XmlElement(name = "first_name")
  private String firstName;
  @XmlElement(name = "last_name")
  private String lastName;
  @XmlElement
  private double salary;
  @XmlElement(name = "observing_star_id")
  private Long observingStarId;

  @NotNull
  @DecimalMin(value = "500")
  public double getAverageObservationHours() {
    return averageObservationHours;
  }

  public String getBirthday() {
    return birthday;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getLastName() {
    return lastName;
  }

  @NotNull
  @DecimalMin(value = "15000")
  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public Long getObservingStarId() {
    return observingStarId;
  }

  public void setAverageObservationHours(double averageObservationHours) {
    this.averageObservationHours = averageObservationHours;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setObservingStarId(Long observingStarId) {
    this.observingStarId = observingStarId;
  }
}

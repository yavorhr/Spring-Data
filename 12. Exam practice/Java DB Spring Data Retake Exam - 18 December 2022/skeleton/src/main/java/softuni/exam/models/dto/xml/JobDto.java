package softuni.exam.models.dto.xml;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.FIELD)
public class JobDto {

  @XmlElement(name = "jobTitle")
  private String title;
  @XmlElement(name = "hoursAWeek")
  private Double hoursAweek;
  @XmlElement
  private Double salary;
  @XmlElement
  private String description;
  @XmlElement
  private Long companyId;

  @NotNull
  @Size(min = 2,max = 40)
  public String getTitle() {
    return title;
  }

  @NotNull
  @Min(value = 10)
  public Double getHoursAweek() {
    return hoursAweek;
  }

  @Min(value = 300)
  public Double getSalary() {
    return salary;
  }

  @Size(min = 5)
  public String getDescription() {
    return description;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setHoursAweek(Double hoursAweek) {
    this.hoursAweek = hoursAweek;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }
}

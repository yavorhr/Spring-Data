package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {
  private String title;
  private Double salary;
  private Double hoursAweek;
  private String description;
  private List<Company> companies;

  public Job() {
    this.companies = new ArrayList<>();
  }

  @Column(nullable = false)
  public String getTitle() {
    return title;
  }

  @Column(nullable = false)
  public Double getSalary() {
    return salary;
  }

  @Column(name = "hours_a_week", nullable = false)
  public Double getHoursAweek() {
    return hoursAweek;
  }

  @Column(nullable = false, columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @ManyToMany
  public List<Company> getCompanies() {
    return companies;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public void setHoursAweek(Double hoursAweek) {
    this.hoursAweek = hoursAweek;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompanies(List<Company> companies) {
    this.companies = companies;
  }
}

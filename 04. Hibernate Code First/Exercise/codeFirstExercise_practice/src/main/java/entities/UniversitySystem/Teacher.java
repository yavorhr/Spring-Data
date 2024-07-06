package entities.UniversitySystem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends User {
  private String email;
  private BigDecimal salaryPerHour;
  private Set<Course> courses;

  public Teacher() {
    this.courses = new HashSet<>();
  }

  @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
  public Set<Course> getCourses() {
    return this.courses;
  }

  @Column(name = "email", nullable = false, unique = true)
  public String getEmail() {
    return email;
  }

  @Column(name = "salary_per_hour", scale = 3, precision = 10)
  public BigDecimal getSalaryPerHour() {
    return salaryPerHour;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setSalaryPerHour(BigDecimal salaryPerHour) {
    this.salaryPerHour = salaryPerHour;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }

}

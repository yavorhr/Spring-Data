package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "teachers")
public class Teacher extends User {
  private String email;
  private BigDecimal salaryPerHour;

  public Teacher() {
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
}

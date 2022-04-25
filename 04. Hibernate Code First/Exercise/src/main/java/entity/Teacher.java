package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends User{
    @Column(name = "email")
    private String email;
    @Column(name="salary_per_hour")
    private BigDecimal salaryPerHour;
    //един учител към много курсове
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher() {
    }

    public String getEmail() {
        return email;
    }

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

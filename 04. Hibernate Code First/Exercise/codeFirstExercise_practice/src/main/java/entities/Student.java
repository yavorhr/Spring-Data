package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {
  private double averageGrade;
  private int attendance;
  private Set<Course> courses;

  public Student() {
    this.courses = new HashSet<>();
  }

  @ManyToMany (mappedBy = "students")
  public Set<Course> getCourses() {
    return this.courses;
  }

  public void setCourses(Set<Course> courses) {
    this.courses = courses;
  }

  @Column(name = "average_grade", nullable = false)
  public double getAverageGrade() {
    return this.averageGrade;
  }

  @Column(name = "attendance", nullable = false)
  public int getAttendance() {
    return this.attendance;
  }

  public void setAverageGrade(double averageGrade) {
    this.averageGrade = averageGrade;
  }

  public void setAttendance(int attendance) {
    this.attendance = attendance;
  }
}

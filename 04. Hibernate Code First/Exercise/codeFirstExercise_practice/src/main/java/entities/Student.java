package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User{
  private double averageGrade;
  private int attendance;

  public Student() {
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

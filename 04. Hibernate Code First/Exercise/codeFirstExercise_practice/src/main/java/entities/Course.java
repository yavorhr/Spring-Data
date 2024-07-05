package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {
  private String name;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;
  private double credits;

  private Teacher teacher;
  private Set<Student> students;

  public Course() {
    this.students = new HashSet<>();
  }

  @ManyToOne
  public Teacher getTeacher() {
    return teacher;
  }

  @ManyToMany
  public Set<Student> getStudents() {
    return students;
  }

  @Column(unique = true, name = "name")
  public String getName() {
    return name;
  }

  @Column(name = "description", columnDefinition = "TEXT")
  public String getDescription() {
    return description;
  }

  @Column(name = "start_date", nullable = false)
  public LocalDate getStartDate() {
    return startDate;
  }

  @Column(name = "end_date", nullable = false)
  public LocalDate getEndDate() {
    return endDate;
  }

  @Column(name = "credits")
  public double getCredits() {
    return credits;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setCredits(double credits) {
    this.credits = credits;
  }

  public void setStudents(Set<Student> students) {
    this.students = students;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
}

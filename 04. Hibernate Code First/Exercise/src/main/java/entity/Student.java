package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {

    @Column(name="average_grades")
    private Float averageGrade;
    @Column(name = "attendances")
    private Integer attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
    public Student() {
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Float getAverageGrade() {
        return averageGrade;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAverageGrade(Float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}

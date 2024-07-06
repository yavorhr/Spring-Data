package entities.HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
  private LocalDateTime dateAndTime;
  private String comment;
  private Patient patient;

  public Visit() {
  }

  public Visit(LocalDateTime dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  @ManyToOne
  public Patient getPatient() {
    return this.patient;
  }

  @Column(name = "date_and_time", nullable = false)
  public LocalDateTime getDateAndTime() {
    return this.dateAndTime;
  }

  @Column(name = "comment", columnDefinition = "TEXT")
  public String getComment() {
    return this.comment;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public void setDateAndTime(LocalDateTime dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}

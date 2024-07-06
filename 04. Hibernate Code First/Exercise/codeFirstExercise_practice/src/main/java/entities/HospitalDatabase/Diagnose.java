package entities.HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
  private String name;
  private String comment;
  private Patient patient;

  public Diagnose() {
  }

  public Diagnose(String name) {
    this.name = name;
  }

  @ManyToOne
  public Patient getPatient() {
    return patient;
  }

  @Column(name = "name", nullable = false, unique = true)
  public String getName() {
    return name;
  }

  @Column(name = "comment", columnDefinition = "TEXT")
  public String getComment() {
    return comment;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}

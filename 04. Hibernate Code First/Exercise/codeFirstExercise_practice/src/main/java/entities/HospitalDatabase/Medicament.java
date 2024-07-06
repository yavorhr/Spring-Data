package entities.HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {
  private String name;
  private Patient patient;

  public Medicament() {
  }

  public Medicament(String name) {
    this.name = name;
  }

  @ManyToOne
  public Patient getPatient() {
    return this.patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  @Column(name = "name", unique = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private LocalDate dateOfBirth;
  private String picture;
  private boolean medicalInsurance;
  private Set<Medicament> medicaments;
  private Set<Visitation> visitations;
  private Set<Diagnose> diagnoses;

  public Patient() {
    this.medicaments = new HashSet<>();
    this.visitations = new HashSet<>();
    this.diagnoses = new HashSet<>();
  }

  @ManyToMany(mappedBy = "patients")
  public Set<Medicament> getMedicaments() {
    return medicaments;
  }

  @OneToMany(mappedBy = "patient")
  public Set<Visitation> getVisitations() {
    return visitations;
  }

  @ManyToMany(mappedBy = "patients")
  public Set<Diagnose> getDiagnoses() {
    return diagnoses;
  }

  public void setVisitations(Set<Visitation> visitations) {
    this.visitations = visitations;
  }

  @Column(name = "first_name", length = 60, nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", length = 60, nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  @Column(name = "email", unique = true)
  public String getEmail() {
    return email;
  }

  @Column(name = "date_of_birth", nullable = false)
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  @Column(name = "picture")
  public String getPicture() {
    return this.picture;
  }

  @Column(name = "medical_insurance")
  public boolean isMedicalInsurance() {
    return medicalInsurance;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public void setMedicalInsurance(boolean medicalInsurance) {
    this.medicalInsurance = medicalInsurance;
  }

  public void setMedicaments(Set<Medicament> medicaments) {
    this.medicaments = medicaments;
  }

  public void setDiagnoses(Set<Diagnose> diagnoses) {
    this.diagnoses = diagnoses;
  }

}

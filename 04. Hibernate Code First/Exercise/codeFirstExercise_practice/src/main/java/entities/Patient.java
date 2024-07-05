package entities;

import com.mysql.cj.jdbc.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private LocalDate dateOfBirth;
  private Blob picture;
  private boolean medicalInsurance;

  public Patient() {
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
  public Blob getPicture() {
    return picture;
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

  public void setPicture(Blob picture) {
    this.picture = picture;
  }

  public void setMedicalInsurance(boolean medicalInsurance) {
    this.medicalInsurance = medicalInsurance;
  }
}

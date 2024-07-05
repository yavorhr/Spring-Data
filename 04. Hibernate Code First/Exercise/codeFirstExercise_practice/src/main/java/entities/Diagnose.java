package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
  private String name;
  private String comment;
  private Set<Patient> patients;

  public Diagnose() {
    this.patients = new HashSet<>();
  }

  @ManyToMany
  public Set<Patient> getPatients() {
    return patients;
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

  public void setPatients(Set<Patient> patients) {
    this.patients = patients;
  }
}

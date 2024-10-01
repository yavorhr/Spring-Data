package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
  private String email;
  private String firstName;
  private String lastName;
  private LocalDate registeredOn;
  private Town town;

  public Customer() {
  }

  @Column(nullable = false, unique = true)
  public String getEmail() {
    return email;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(name = "registered_on", nullable = false)
  public LocalDate getRegisteredOn() {
    return registeredOn;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public Customer setEmail(String email) {
    this.email = email;
    return this;
  }

  public Customer setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Customer setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Customer setRegisteredOn(LocalDate registeredOn) {
    this.registeredOn = registeredOn;
    return this;
  }

  public Customer setTown(Town town) {
    this.town = town;
    return this;
  }
}

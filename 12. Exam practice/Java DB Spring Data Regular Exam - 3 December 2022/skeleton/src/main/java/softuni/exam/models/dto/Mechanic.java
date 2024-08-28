package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;

  public Mechanic() {
  }

  @Column(name = "first_name", unique = true, nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(name = "email", unique = true, nullable = false)
  public String getEmail() {
    return email;
  }

  @Column(unique = true)
  public String getPhone() {
    return phone;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}

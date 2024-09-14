package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "library_members")
public class LibraryMember extends BaseEntity {
  private String address;
  private String firstName;
  private String lastName;
  private String phoneNumber;

  public LibraryMember() {
  }

  @Column
  public String getAddress() {
    return address;
  }

  @Column(nullable = false, name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  @Column(nullable = false, name = "last_name")
  public String getLastName() {
    return lastName;
  }

  @Column(name = "phone_number", nullable = false, unique = true)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}

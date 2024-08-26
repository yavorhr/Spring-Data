package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.StatusTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private StatusTypeEnum statusType;
  private Country country;

  public Person() {
  }


  @Column(nullable = false)
  public String getFirstName() {
    return firstName;
  }

  @Column(nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(unique = true,nullable = false)
  public String getEmail() {
    return email;
  }

  @Column(unique = true)
  public String getPhone() {
    return phone;
  }

  @Enumerated
  public StatusTypeEnum getStatusType() {
    return statusType;
  }

  @ManyToOne
  public Country getCountry() {
    return country;
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

  public void setStatusType(StatusTypeEnum statusType) {
    this.statusType = statusType;
  }

  public void setCountry(Country country) {
    this.country = country;
  }
}

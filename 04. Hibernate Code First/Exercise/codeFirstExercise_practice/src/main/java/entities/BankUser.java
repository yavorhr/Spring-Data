package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class BankUser extends BaseEntity {
  @Column(nullable = false,name="first_name")
  private String firstName;

  @Column(nullable = false,name="last_name")
  private String lastName;

  @Column(nullable = false,name="email")
  private String email;

  @Column(nullable = false,name="password")
  private String password;

  public BankUser(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public BankUser() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}

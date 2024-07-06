package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank_users")
public class BankUser extends BaseEntity {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Set<BillingDetail> billingDetails;

  public BankUser(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.billingDetails = new HashSet<>();
  }

  public BankUser() {
    this.billingDetails = new HashSet<>();
  }

  @OneToMany(mappedBy = "owner")
  public Set<BillingDetail> getBillingDetails() {
    return this.billingDetails;
  }

  @Column(nullable = false, name = "first_name")
  public String getFirstName() {
    return this.firstName;
  }

  @Column(nullable = false, name = "last_name")
  public String getLastName() {
    return this.lastName;
  }

  @Column(nullable = false, name = "email")
  public String getEmail() {
    return this.email;
  }

  @Column(nullable = false, name = "password")
  public String getPassword() {
    return password;
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

  public void setPassword(String password) {
    this.password = password;
  }

  public void setBillingDetails(Set<BillingDetail> billingDetails) {
    this.billingDetails = billingDetails;
  }
}

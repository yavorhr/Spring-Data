package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
  private String name;
  private String email;
  private String creditCardNumber;

  public Customer() {
  }

  @Column(name = "name",nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "email", unique = true, nullable = false)
  public String getEmail() {
    return email;
  }

  @Column(name = "credit_card_number", unique = true, nullable = false)
  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }
}

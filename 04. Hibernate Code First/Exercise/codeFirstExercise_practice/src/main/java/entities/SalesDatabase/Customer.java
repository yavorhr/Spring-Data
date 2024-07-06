package entities.SalesDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
  private String name;
  private String email;
  private String creditCardNumber;
  private Set<Sale> sales;

  public Customer() {
    this.sales = new HashSet<>();
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

  @OneToMany(mappedBy = "customer")
  public Set<Sale> getSales() {
    return sales;
  }

  public void setSales(Set<Sale> sales) {
    this.sales = sales;
  }
}

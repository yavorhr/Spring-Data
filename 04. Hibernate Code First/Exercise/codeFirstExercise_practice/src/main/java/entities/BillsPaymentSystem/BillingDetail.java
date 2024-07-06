package entities.BillsPaymentSystem;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail extends BaseEntity {

  private String number;
  private BankUser owner;

  public BillingDetail(String number) {
    this.number = number;
  }

  public BillingDetail() {
  }

  @Column(name = "number", unique = true)
  public String getNumber() {
    return this.number;
  }

  @ManyToOne
  public BankUser getOwner() {
    return this.owner;
  }

  public void setOwner(BankUser owner) {
    this.owner = owner;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}

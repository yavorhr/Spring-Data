package entities;

import javax.persistence.*;

@Entity
@Table(name = "billing_detail")
@Inheritance(strategy = InheritanceType.JOINED)
public class BillingDetail extends BaseEntity {

  private String number;
  private BankUser owner;

  public BillingDetail(String number) {
    this.number = number;
  }

  public BillingDetail() {
  }

  @Column(name = "number")
  public String getNumber() {
    return this.number;
  }

  @Column(name = "owner")
  @ManyToOne
  public BankUser getOwner() {
    return owner;
  }

  public void setOwner(BankUser owner) {
    this.owner = owner;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}

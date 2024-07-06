package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail {
  private String name;
  private short swiftCode;

  public BankAccount(String name, short swiftCode) {
    this.name = name;
    this.swiftCode = swiftCode;
  }

  public BankAccount(){
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "swift_code")
  public short getSwiftCode() {
    return swiftCode;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSwiftCode(short swiftCode) {
    this.swiftCode = swiftCode;
  }
}

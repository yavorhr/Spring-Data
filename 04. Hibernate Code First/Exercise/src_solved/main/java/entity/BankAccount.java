package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{

    @Column
    private String name;
    @Column(name = "swift_code")
    private String swiftCode;

    public BankAccount() {
    }

    public String getName() {
        return name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}

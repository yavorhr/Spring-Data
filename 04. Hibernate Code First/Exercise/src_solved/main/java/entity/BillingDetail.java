package entity;

import javax.persistence.*;

@Entity
@Table(name="billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String number;

    @ManyToOne
    private BankUser owner;


    public BillingDetail() {
    }


    public String getNumber() {
        return number;
    }

    public BankUser getOwner() {
        return owner;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(BankUser owner) {
        this.owner = owner;
    }
}

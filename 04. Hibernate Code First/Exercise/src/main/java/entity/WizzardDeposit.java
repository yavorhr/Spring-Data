package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizzard_deposit")
public class WizzardDeposit extends BaseEntity {

    @Column(name = "first_name",nullable = true,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false,length = 60)
    private String lastName;

    @Column(name = "notes",length = 1000,columnDefinition = "TEXT")
    private String notes;

    @Column(name="age",nullable = false)
    private Integer age;

    @Column(name = "magic_wand_creator",length = 100)
    private String magicWandCreator;

    @Column(name="magic_wand_size",nullable = false)
    private short magicWandSize;

    @Column(name="deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private LocalDateTime depositStartDate;

    @Column(name = "deposit_amount",precision = 10,scale = 3)
    private BigDecimal depositAmount;

    @Column(name = "deposit_interest")
    private Float depositInterest;

    @Column(name = "deposit_charge")
    private Float depositCharge;

    @Column (name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;

    @Column (name = "is_deposit_expired")
    private Boolean isDepositExpired;

    public WizzardDeposit(){
    }




}

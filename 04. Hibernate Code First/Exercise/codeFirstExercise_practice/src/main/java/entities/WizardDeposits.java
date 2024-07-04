package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class WizardDeposits extends BaseEntity {

  private String firstName;
  private String lastName;
  private String notes;
  private int age;
  private String magicWandCreator;
  private short magicWandSize;
  private String depositGroup;
  private LocalDateTime depositStartDate;
  private BigDecimal depositAmount;
  private Float depositInterest;
  private Float depositCharge;
  private LocalDateTime depositExpirationDate;
  private Boolean isDepositExpired;

  public WizardDeposits() {
  }

  @Column(name = "first_name", length = 50)
  public String getFirstName() {
    return firstName;
  }

  @Column(name = "last_name", length = 60, nullable = false)
  public String getLastName() {
    return lastName;
  }

  @Column(name = "notes", length = 1000, columnDefinition = "TEXT")
  public String getNotes() {
    return notes;
  }

  @Column(name = "age", nullable = false)
  public int getAge() {
    return age;
  }

  @Column(name = "magic_wand_creator", length = 100)
  public String getMagicWandCreator() {
    return magicWandCreator;
  }

  @Column(name = "magic_wand_size", nullable = false)
  public short getMagicWandSize() {
    return magicWandSize;
  }

  @Column(name = "deposit_group", length = 20)
  public String getDepositGroup() {
    return depositGroup;
  }

  @Column(name = "deposit_start_date")
  public LocalDateTime getDepositStartDate() {
    return depositStartDate;
  }

  @Column(name ="deposit_amount")
  public BigDecimal getDepositAmount() {
    return depositAmount;
  }

  @Column(name = "deposit_interest")
  public Float getDepositInterest() {
    return depositInterest;
  }

  @Column(name = "deposit_charge")
  public Float getDepositCharge() {
    return depositCharge;
  }

  @Column(name = "deposit_expiration_date")
  public LocalDateTime getDepositExpirationDate() {
    return depositExpirationDate;
  }

  @Column(name = "is_deposit_expired")
  public Boolean getDepositExpired() {
    return isDepositExpired;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setMagicWandCreator(String magicWandCreator) {
    this.magicWandCreator = magicWandCreator;
  }

  public void setMagicWandSize(short magicWandSize) {
    this.magicWandSize = magicWandSize;
  }

  public void setDepositGroup(String depositGroup) {
    this.depositGroup = depositGroup;
  }

  public void setDepositStartDate(LocalDateTime depositStartDate) {
    this.depositStartDate = depositStartDate;
  }

  public void setDepositAmount(BigDecimal depositAmount) {
    this.depositAmount = depositAmount;
  }

  public void setDepositInterest(Float depositInterest) {
    this.depositInterest = depositInterest;
  }

  public void setDepositCharge(Float depositCharge) {
    this.depositCharge = depositCharge;
  }

  public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
    this.depositExpirationDate = depositExpirationDate;
  }

  public void setDepositExpired(Boolean depositExpired) {
    isDepositExpired = depositExpired;
  }
}

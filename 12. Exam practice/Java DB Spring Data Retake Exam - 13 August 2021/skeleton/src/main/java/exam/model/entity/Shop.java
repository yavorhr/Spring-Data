package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {
  private String address;
  private Integer employeeCount;
  private BigDecimal income;
  private String name;
  private Integer shopArea;
  private Town town;

  public Shop() {
  }

  @Column(nullable = false)
  public String getAddress() {
    return address;
  }

  @Column(nullable = false)
  public Integer getEmployeeCount() {
    return employeeCount;
  }

  @Column(nullable = false)
  public BigDecimal getIncome() {
    return income;
  }

  @Column(nullable = false, unique = true)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public Integer getShopArea() {
    return shopArea;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public Shop setAddress(String address) {
    this.address = address;
    return this;
  }

  public Shop setEmployeeCount(Integer employeeCount) {
    this.employeeCount = employeeCount;
    return this;
  }

  public Shop setIncome(BigDecimal income) {
    this.income = income;
    return this;
  }

  public Shop setName(String name) {
    this.name = name;
    return this;
  }

  public Shop setShopArea(Integer shopArea) {
    this.shopArea = shopArea;
    return this;
  }

  public Shop setTown(Town town) {
    this.town = town;
    return this;
  }
}

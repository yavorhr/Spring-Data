package exam.model.service.xml;

import exam.model.entity.Town;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopDetailsModel {

  @XmlElement
  private String address;
  @XmlElement(name = "employee-count")
  private Integer employeeCount;
  @XmlElement
  private BigDecimal income;
  @XmlElement
  private String name;
  @XmlElement(name = "shop-area")
  private Integer shopArea;
  @XmlElement
  private TownWithNameModel town;

  public String getAddress() {
    return address;
  }

  public ShopDetailsModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public Integer getEmployeeCount() {
    return employeeCount;
  }

  public ShopDetailsModel setEmployeeCount(Integer employeeCount) {
    this.employeeCount = employeeCount;
    return this;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public ShopDetailsModel setIncome(BigDecimal income) {
    this.income = income;
    return this;
  }

  public String getName() {
    return name;
  }

  public ShopDetailsModel setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getShopArea() {
    return shopArea;
  }

  public ShopDetailsModel setShopArea(Integer shopArea) {
    this.shopArea = shopArea;
    return this;
  }

  public TownWithNameModel getTown() {
    return town;
  }

  public ShopDetailsModel setTown(TownWithNameModel town) {
    this.town = town;
    return this;
  }
}

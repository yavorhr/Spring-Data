package exam.model.service.xml;

import exam.model.entity.Town;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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

  @Size(min = 4)
  public String getAddress() {
    return address;
  }

  @Min(1)
  @Max(50)
  public Integer getEmployeeCount() {
    return employeeCount;
  }

  @Min(150)
  public Integer getShopArea() {
    return shopArea;
  }

  @Min(20000)
  public BigDecimal getIncome() {
    return income;
  }

  public ShopDetailsModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public ShopDetailsModel setEmployeeCount(Integer employeeCount) {
    this.employeeCount = employeeCount;
    return this;
  }

  public ShopDetailsModel setIncome(BigDecimal income) {
    this.income = income;
    return this;
  }

  @Size(min = 4)
  public String getName() {
    return name;
  }

  public ShopDetailsModel setName(String name) {
    this.name = name;
    return this;
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

package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {
  private Double cpuSpeed;
  private String description;
  private String macAddress;
  private BigDecimal price;
  private Integer ram;
  private Integer storage;
  private Integer warrantyType;
  private Shop shop;

  public Laptop() {
  }

  @Column(name = "cpu_speed", nullable = false)
  public Double getCpuSpeed() {
    return cpuSpeed;
  }

  @Column(columnDefinition = "TEXT", nullable = false)
  public String getDescription() {
    return description;
  }

  @Column(name = "mac_address", nullable = false, unique = true)
  public String getMacAddress() {
    return macAddress;
  }

  @Column(nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  @Column(nullable = false)
  public Integer getRam() {
    return ram;
  }

  @Column(nullable = false)
  public Integer getStorage() {
    return storage;
  }

  @Column(name = "warranty_type", nullable = false)
  public Integer getWarrantyType() {
    return warrantyType;
  }

  @ManyToOne
  public Shop getShop() {
    return shop;
  }

  public Laptop setCpuSpeed(Double cpuSpeed) {
    this.cpuSpeed = cpuSpeed;
    return this;
  }

  public Laptop setDescription(String description) {
    this.description = description;
    return this;
  }

  public Laptop setMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return this;
  }

  public Laptop setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public Laptop setRam(Integer ram) {
    this.ram = ram;
    return this;
  }

  public Laptop setStorage(Integer storage) {
    this.storage = storage;
    return this;
  }

  public Laptop setWarrantyType(Integer warrantyType) {
    this.warrantyType = warrantyType;
    return this;
  }

  public Laptop setShop(Shop shop) {
    this.shop = shop;
    return this;
  }
}

package exam.model.service.json;

import com.google.gson.annotations.Expose;
import exam.model.entity.WarrantyTypeEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopDetailsModel {
  @Expose
  private Double cpuSpeed;
  @Expose
  private String description;
  @Expose
  private String macAddress;
  @Expose
  private BigDecimal price;
  @Expose
  private Integer ram;
  @Expose
  private Integer storage;
  @Expose
  private WarrantyTypeEnum warrantyType;
  @Expose
  private ShopWithNameModel shop;

  public LaptopDetailsModel() {
  }

  @NotNull
  @Positive
  public Double getCpuSpeed() {
    return cpuSpeed;
  }

  @NotNull
  @Size(min = 10)
  public String getDescription() {
    return description;
  }

  @NotNull
  @Size(min = 8)
  public String getMacAddress() {
    return macAddress;
  }

  @NotNull
  @Positive
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull
  @Min(8)
  @Max(128)
  public Integer getRam() {
    return ram;
  }

  @NotNull
  @Min(128)
  @Max(1024)
  public Integer getStorage() {
    return storage;
  }

  @NotNull
  @Enumerated
  public WarrantyTypeEnum getWarrantyType() {
    return warrantyType;
  }

  @NotNull
  public ShopWithNameModel getShop() {
    return shop;
  }

  public LaptopDetailsModel setCpuSpeed(Double cpuSpeed) {
    this.cpuSpeed = cpuSpeed;
    return this;
  }

  public LaptopDetailsModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public LaptopDetailsModel setMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return this;
  }

  public LaptopDetailsModel setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public LaptopDetailsModel setRam(Integer ram) {
    this.ram = ram;
    return this;
  }

  public LaptopDetailsModel setStorage(Integer storage) {
    this.storage = storage;
    return this;
  }

  public LaptopDetailsModel setWarrantyType(WarrantyTypeEnum warrantyType) {
    this.warrantyType = warrantyType;
    return this;
  }

  public LaptopDetailsModel setShop(ShopWithNameModel shop) {
    this.shop = shop;
    return this;
  }
}

package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PartSeedDto {
  @Expose
  private String partName;
  @Expose
  private Double price;
  @Expose
  private Integer quantity;

  @NotNull
  @Size(min = 2, max = 19)
  public String getPartName() {
    return partName;
  }

  @NotNull
  @Positive
  public Double getPrice() {
    return price;
  }

  @NotNull
  @Positive
  public Integer getQuantity() {
    return quantity;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}

package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    private String  partName;
    private Double price;
    private Integer quantity;

  public Part() {
  }
  @Column(name = "part_name", nullable = false,unique = true)
  public String getPartName() {
    return partName;
  }

  @Column(nullable = false)
  public Double getPrice() {
    return price;
  }

  @Column(nullable = false)
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

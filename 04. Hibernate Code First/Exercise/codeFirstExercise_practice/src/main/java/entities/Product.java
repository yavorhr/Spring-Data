package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity {
  private String name;
  private Long quantity;
  private BigDecimal price;

  public Product() {
  }

  @Column(name = "name",unique = true)
  public String getName() {
    return name;
  }

  @Column(name = "quantity")
  public Long getQuantity() {
    return quantity;
  }

  @Column(name = "price", nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}

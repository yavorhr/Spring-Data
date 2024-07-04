package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
  private String name;
  private Long quantity;
  private BigDecimal price;
  private Set<Sale> sales;

  public Product() {
    this.sales = new HashSet<>();
  }

  @OneToMany(mappedBy = "product",
          cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  public Set<Sale> getSales() {
    return sales;
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

  public void setSales(Set<Sale> sales) {
    this.sales = sales;
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

package entities.SalesDatabase;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name ="sales")
public class Sale extends BaseEntity {
  private Product product;
  private Customer customer;
  private StoreLocation storeLocation;
  private LocalDateTime date;

  public Sale() {
  }

  // many Sales for one product
  @ManyToOne
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  // many sales per one customer
  @ManyToOne
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  // many sales in one store
  @ManyToOne
  public StoreLocation getStoreLocation() {
    return storeLocation;
  }

  public void setStoreLocation(StoreLocation storeLocation) {
    this.storeLocation = storeLocation;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}

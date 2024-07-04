package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sales")
public class Sale extends BaseEntity{
        //Many sales -> one product
        @ManyToOne
        private Product product;
        @ManyToOne
        private Customer customer;

        @ManyToOne
        private  StoreLocation storeLocation;

        @Column(name = "date_time")
        private LocalDateTime localDate;

    public Sale() {
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }
}

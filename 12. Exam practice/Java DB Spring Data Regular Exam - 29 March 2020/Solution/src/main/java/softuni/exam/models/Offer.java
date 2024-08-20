package softuni.exam.models;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    private BigDecimal price;
    private String description;
    private boolean hasGoldStatus;
    private LocalDateTime addedOn;

    private Car car;
    private Seller seller;
    private List<Picture> pictures;

    public Offer() {
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    @ManyToMany
    public List<Picture> getPictures() {
        return pictures;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column(name = "has_gold_status")
    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }
}

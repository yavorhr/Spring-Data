package softuni.exam.models.entity;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
  private BigDecimal price;
  private String description;
  private double hasGoldStatus;
  private LocalDateTime addedOn;
  private Car car;
  private Seller seller;
  private Set<Picture> pictures;

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
  public Set<Picture> getPictures() {
    return pictures;
  }

  @Column
  @Min(value = 1, message = "The price must be a positive number")
  public BigDecimal getPrice() {
    return price;
  }

  @Column(columnDefinition = "TEXT")
  @Min(value = 5, message = "The description must be at least 5 characters long")
  public String getDescription() {
    return description;
  }

  @Column(name = "has_gold_status")
  public double getHasGoldStatus() {
    return hasGoldStatus;
  }

  @Column(name = "added_on")
  public LocalDateTime getAddedOn() {
    return addedOn;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHasGoldStatus(double hasGoldStatus) {
    this.hasGoldStatus = hasGoldStatus;
  }

  public void setAddedOn(LocalDateTime addedOn) {
    this.addedOn = addedOn;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public void setSeller(Seller seller) {
    this.seller = seller;
  }

  public void setPictures(Set<Picture> pictures) {
    this.pictures = pictures;
  }
}

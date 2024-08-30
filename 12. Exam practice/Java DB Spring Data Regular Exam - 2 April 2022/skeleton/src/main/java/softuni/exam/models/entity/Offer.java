package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
  private BigDecimal price;
  private LocalDate publishedOn;
  private Agent agent;
  private Apartment apartment;

  public Offer() {
  }

  @Column(nullable = false)
  public BigDecimal getPrice() {
    return price;
  }

  @Column(columnDefinition = "DATE", nullable = false)
  public LocalDate getPublishedOn() {
    return publishedOn;
  }

  @ManyToOne
  public Agent getAgent() {
    return agent;
  }

  @ManyToOne
  public Apartment getApartment() {
    return apartment;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setPublishedOn(LocalDate publishedOn) {
    this.publishedOn = publishedOn;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public void setApartment(Apartment apartment) {
    this.apartment = apartment;
  }
}

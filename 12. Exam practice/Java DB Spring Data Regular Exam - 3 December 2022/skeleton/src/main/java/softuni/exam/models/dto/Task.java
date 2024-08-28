package softuni.exam.models.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
  private LocalDateTime date;
  private double price;
  private Mechanic mechanic;
  private Part part;
  private Car car;

  public Task() {
  }

  @Column(nullable = false)
  public LocalDateTime getDate() {
    return date;
  }

  @Column(nullable = false)
  public double getPrice() {
    return price;
  }

  @ManyToOne
  public Mechanic getMechanic() {
    return mechanic;
  }

  @ManyToOne
  public Part getPart() {
    return part;
  }

  @ManyToOne
  public Car getCar() {
    return car;
  }

  public void setDate(LocalDateTime dateTime) {
    this.date = dateTime;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setMechanic(Mechanic mechanic) {
    this.mechanic = mechanic;
  }

  public void setPart(Part part) {
    this.part = part;
  }

  public void setCar(Car car) {
    this.car = car;
  }
}

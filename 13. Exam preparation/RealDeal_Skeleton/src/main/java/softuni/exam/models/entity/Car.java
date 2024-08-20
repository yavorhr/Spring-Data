package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
  private String make;
  private String model;
  private Integer kilometers;
  private LocalDate registeredOn;

  public Car() {
  }

  @Column(length = 19)
  public String getMake() {
    return make;
  }

  @Column(length = 19)
  public String getModel() {
    return model;
  }

  @Column
  public Integer getKilometers() {
    return kilometers;
  }

  @Column(name = "registered_on")
  public LocalDate getRegisteredOn() {
    return registeredOn;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setKilometers(Integer kilometers) {
    this.kilometers = kilometers;
  }

  public void setRegisteredOn(LocalDate registeredOn) {
    this.registeredOn = registeredOn;
  }
}

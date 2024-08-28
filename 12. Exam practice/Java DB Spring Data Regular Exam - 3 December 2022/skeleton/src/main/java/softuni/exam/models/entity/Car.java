package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
  private CarTypeEnum carType;
  private String make;
  private String model;
  private Integer year;
  private String plateNumber;
  private Integer kilometers;
  private Double engine;

  public Car() {
  }

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  public CarTypeEnum getCarType() {
    return carType;
  }

  @Column(nullable = false)
  public String getMake() {
    return make;
  }

  @Column(nullable = false)
  public String getModel() {
    return model;
  }

  @Column(nullable = false)
  public Integer getYear() {
    return year;
  }

  @Column(nullable = false,unique = true,name = "plate_number")
  public String getPlateNumber() {
    return plateNumber;
  }

  @Column(nullable = false)
  public Integer getKilometers() {
    return kilometers;
  }

  @Column(nullable = false)
  public Double getEngine() {
    return engine;
  }

  public void setCarType(CarTypeEnum carType) {
    this.carType = carType;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  public void setKilometers(Integer kilometers) {
    this.kilometers = kilometers;
  }

  public void setEngine(Double engine) {
    this.engine = engine;
  }
}

package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.CarTypeEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedDto {
  @XmlElement(name = "carMake")
  private String make;
  @XmlElement(name = "carModel")
  private String model;
  @XmlElement
  private Integer year;
  @XmlElement(name = "plateNumber")
  private String plateNumber;
  @XmlElement
  private Integer kilometers;
  @XmlElement(name = "carType")
  private CarTypeEnum carType;
  @XmlElement
  private Double engine;

  @NotNull
  @Size(min = 2, max = 30)
  public String getMake() {
    return make;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getModel() {
    return model;
  }

  @NotNull
  @Positive
  public Integer getYear() {
    return year;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getPlateNumber() {
    return plateNumber;
  }

  @NotNull
  @Positive
  public Integer getKilometers() {
    return kilometers;
  }

  @Enumerated
  public CarTypeEnum getCarType() {
    return carType;
  }

  @NotNull
  @Min(1)
  public Double getEngine() {
    return engine;
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

  public void setCarType(CarTypeEnum carType) {
    this.carType = carType;
  }

  public void setEngine(Double engine) {
    this.engine = engine;
  }
}

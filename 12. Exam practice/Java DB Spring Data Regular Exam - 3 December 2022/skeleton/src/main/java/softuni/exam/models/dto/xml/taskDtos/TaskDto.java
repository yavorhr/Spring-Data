package softuni.exam.models.dto.xml.taskDtos;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDto {

  @XmlElement
  private String date;
  @XmlElement
  private Double price;
  @XmlElement(name = "car")
  private CarWithIdDto car;
  @XmlElement(name = "mechanic")
  private MechanicWithFirstName mechanic;
  @XmlElement(name = "part")
  private PartWithIdDto part;

  public String getDate() {
    return date;
  }

  @Positive
  public Double getPrice() {
    return price;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public CarWithIdDto getCar() {
    return car;
  }

  public void setCar(CarWithIdDto car) {
    this.car = car;
  }

  public MechanicWithFirstName getMechanic() {
    return mechanic;
  }

  public void setMechanic(MechanicWithFirstName mechanic) {
    this.mechanic = mechanic;
  }

  public PartWithIdDto getPart() {
    return part;
  }

  public void setPart(PartWithIdDto part) {
    this.part = part;
  }



}




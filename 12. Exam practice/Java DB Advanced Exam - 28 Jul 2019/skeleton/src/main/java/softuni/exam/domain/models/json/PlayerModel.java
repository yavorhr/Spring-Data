package softuni.exam.domain.models.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.exam.domain.entities.PositionEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PlayerModel {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private Integer number;
  @Expose
  private BigDecimal salary;
  @Expose
  private PositionEnum position;
  @Expose
  @SerializedName("picture")
  private PictureUrl picture;
  @Expose
  @SerializedName("team")
  private PlayerTeam team;

  public PictureUrl getPicture() {
    return picture;
  }

  public PlayerTeam getTeam() {
    return team;
  }

  public String getFirstName() {
    return firstName;
  }

  @Size(min = 3,max = 15)
  public String getLastName() {
    return lastName;
  }

  @Min(1)
  @Max(99)
  public Integer getNumber() {
    return number;
  }

  @Positive
  public BigDecimal getSalary() {
    return salary;
  }

  @Enumerated
  public PositionEnum getPosition() {
    return position;
  }

  public PlayerModel setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PlayerModel setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PlayerModel setNumber(Integer number) {
    this.number = number;
    return this;
  }

  public PlayerModel setSalary(BigDecimal salary) {
    this.salary = salary;
    return this;
  }

  public PlayerModel setPosition(PositionEnum position) {
    this.position = position;
    return this;
  }

  public PlayerModel setPicture(PictureUrl picture) {
    this.picture = picture;
    return this;
  }
}

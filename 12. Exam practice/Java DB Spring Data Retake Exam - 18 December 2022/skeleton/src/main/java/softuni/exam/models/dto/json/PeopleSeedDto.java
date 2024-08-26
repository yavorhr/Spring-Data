package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.enums.StatusTypeEnum;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PeopleSeedDto {
  @Expose
  private String email;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String phone;
  @Expose
  private StatusTypeEnum statusType;
  @Expose
  private Long country;

  @NotNull
  @Size(min = 2, max = 30)
  public String getFirstName() {
    return firstName;
  }

  @Size(min = 2, max = 30)
  public String getLastName() {
    return lastName;
  }

  @NotBlank
  @NotNull
  @Email
  public String getEmail() {
    return email;
  }

  @Size(min = 2, max = 30)
  public String getPhone() {
    return phone;
  }

  public StatusTypeEnum getStatusType() {
    return statusType;
  }

  public Long getCountry() {
    return country;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setStatusType(StatusTypeEnum statusType) {
    this.statusType = statusType;
  }

  public void setCountry(Long country) {
    this.country = country;
  }
}

package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberSeedDto {
  @Expose
  private String address;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String phoneNumber;

  public MemberSeedDto() {
  }

  @Size(min = 2, max = 40)
  public String getAddress() {
    return address;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Size(min = 2, max = 30)
  public String getLastName() {
    return lastName;
  }

  @NotNull
  @Size(min = 2, max = 20)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}

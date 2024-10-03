package exam.model.service.json;

import com.google.gson.annotations.Expose;
import exam.model.entity.Town;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDetailsModel {
  @Expose
  private String email;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String registeredOn;
  @Expose
  private CustomerTownModel town;

  public CustomerDetailsModel() {
  }

  public CustomerTownModel getTown() {
    return town;
  }

  @NotNull
  @Email
  public String getEmail() {
    return email;
  }

  @NotNull
  @Size(min = 2)
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Size(min = 2)
  public String getLastName() {
    return lastName;
  }

  @NotNull
  public String getRegisteredOn() {
    return registeredOn;
  }

  public CustomerDetailsModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerDetailsModel setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public CustomerDetailsModel setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public CustomerDetailsModel setRegisteredOn(String registeredOn) {
    this.registeredOn = registeredOn;
    return this;
  }

  public CustomerDetailsModel setTown(CustomerTownModel town) {
    this.town = town;
    return this;
  }
}

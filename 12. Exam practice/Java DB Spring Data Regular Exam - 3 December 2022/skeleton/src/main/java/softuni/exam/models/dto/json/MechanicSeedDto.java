package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MechanicSeedDto {
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String email;
  @Expose
  private String phone;

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
  @Email
  public String getEmail() {
    return email;
  }

  @Size(min = 2)
  public String getPhone() {
    return phone;
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
}

package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AgentsSeedDtos {
  @Expose
  private String firstName;
  @Expose
  private String latName;
  @Expose
  private String town;
  @Expose
  private String email;

  @NotNull
  @Size(min = 2)
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Size(min = 2)
  public String getLatName() {
    return latName;
  }

  @NotNull
  public String getTown() {
    return town;
  }

  @Email
  @NotNull
  public String getEmail() {
    return email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLatName(String latName) {
    this.latName = latName;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

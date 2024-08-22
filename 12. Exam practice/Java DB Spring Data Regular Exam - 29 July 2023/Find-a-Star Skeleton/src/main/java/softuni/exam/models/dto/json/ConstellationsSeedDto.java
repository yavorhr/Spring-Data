package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class ConstellationsSeedDto {

  @Expose
  private String name;
  @Expose
  private String description;

  @Size(min = 3, max = 20)
  public String getName() {
    return name;
  }

  @Size(min = 5)
  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

package exam.model.service.json;

import com.google.gson.annotations.Expose;

public class CustomerTownModel {

  @Expose
  private String name;

  public String getName() {
    return name;
  }

  public CustomerTownModel setName(String name) {
    this.name = name;
    return this;
  }
}

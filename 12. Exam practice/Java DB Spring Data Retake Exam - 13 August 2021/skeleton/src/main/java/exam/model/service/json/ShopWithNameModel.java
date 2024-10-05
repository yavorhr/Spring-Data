package exam.model.service.json;

import com.google.gson.annotations.Expose;

public class ShopWithNameModel {

  @Expose
  private String name;

  public String getName() {
    return name;
  }

  public ShopWithNameModel setName(String name) {
    this.name = name;
    return this;
  }
}

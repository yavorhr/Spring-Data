package softuni.exam.domain.models.json;

import com.google.gson.annotations.Expose;

public class PlayerTeam {

  @Expose
  private String name;
  @Expose
  private PictureUrl picture;

  public PlayerTeam() {
  }

  public String getName() {
    return name;
  }

  public PlayerTeam setName(String name) {
    this.name = name;
    return this;
  }

  public PictureUrl getPicture() {
    return picture;
  }

  public PlayerTeam setPicture(PictureUrl picture) {
    this.picture = picture;
    return this;
  }
}

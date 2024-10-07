package softuni.exam.domain.models.json;


import com.google.gson.annotations.Expose;

public class PictureUrl {

  @Expose
  private String url;

  public PictureUrl() {
  }

  public String getUrl() {
    return url;
  }

  public PictureUrl setUrl(String url) {
    this.url = url;
    return this;
  }
}

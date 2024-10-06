package softuni.exam.domain.models.xml;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureDetailsModel {

  @XmlElement(name = "url")
  private String url;

  public PictureDetailsModel() {
  }

  @NotNull
  @NotEmpty
  public String getUrl() {
    return url;
  }

  public PictureDetailsModel setUrl(String url) {
    this.url = url;
    return this;
  }
}

package softuni.exam.domain.models.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamDetailsPictureModel {
  @XmlElement(name = "url")
  private String url;

  public String getUrl() {
    return url;
  }

  public TeamDetailsPictureModel setUrl(String url) {
    this.url = url;
    return this;
  }
}

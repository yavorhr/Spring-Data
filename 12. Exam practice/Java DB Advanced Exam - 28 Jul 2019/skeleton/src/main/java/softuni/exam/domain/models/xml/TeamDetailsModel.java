package softuni.exam.domain.models.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamDetailsModel {

  @XmlElement(name = "name")
  private String name;
  @XmlElement(name = "picture")
  private TeamDetailsPictureModel picture;

  public String getName() {
    return name;
  }

  public TeamDetailsModel setName(String name) {
    this.name = name;
    return this;
  }

  public TeamDetailsPictureModel getPicture() {
    return picture;
  }

  public TeamDetailsModel setPicture(TeamDetailsPictureModel picture) {
    this.picture = picture;
    return this;
  }
}

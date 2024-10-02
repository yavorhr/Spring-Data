package exam.model.service.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownWithNameModel {

  @XmlElement(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public TownWithNameModel setName(String name) {
    this.name = name;
    return this;
  }
}

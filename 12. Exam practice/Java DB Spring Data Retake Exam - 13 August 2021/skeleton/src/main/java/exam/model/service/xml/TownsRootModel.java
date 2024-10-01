package exam.model.service.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsRootModel {

  @XmlElement(name = "town")
  private List<TownDetailsModel> towns;

  public List<TownDetailsModel> getTowns() {
    return towns;
  }
}

package softuni.exam.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersRootSeedDto {

  @XmlElement(name = "astronomer")
  private List<AstronomerDataDto> astronomers;

  public void setAstronomers(List<AstronomerDataDto> astronomers) {
    this.astronomers = astronomers;
  }

  public List<AstronomerDataDto> getAstronomers() {
    return astronomers;
  }
}

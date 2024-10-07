package softuni.exam.domain.models.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamsRootModel {

  @XmlElement(name = "team")
  private List<TeamDetailsModel> teams;

  public List<TeamDetailsModel> getTeams() {
    return teams;
  }

  public TeamsRootModel setTeams(List<TeamDetailsModel> teams) {
    this.teams = teams;
    return this;
  }
}

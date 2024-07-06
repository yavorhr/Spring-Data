package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntityWithName {
  private CompetitionType competitionType;

  public Competition(CompetitionType competitionType) {
    this.competitionType = competitionType;
  }

  public Competition() {
  }

  @ManyToOne
  public CompetitionType getCompetitionType() {
    return this.competitionType;
  }

  public void setCompetitionType(CompetitionType competitionType) {
    this.competitionType = competitionType;
  }
}

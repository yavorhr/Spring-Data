package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {
  private String name;
  private CompetitionType competitionType;

  public Competition(CompetitionType competitionType, String name) {
    this.competitionType = competitionType;
    this.name = name;
  }

  public Competition() {
  }

  @ManyToOne
  public CompetitionType getCompetitionType() {
    return this.competitionType;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  public void setCompetitionType(CompetitionType competitionType) {
    this.competitionType = competitionType;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity {
    private String competition_type;

  public CompetitionType(String type) {
    this.competition_type = type;
  }

  public CompetitionType() {
  }

  @Column(name = "type", nullable = false)
  public String getCompetition_type() {
    return this.competition_type;
  }

  public void setCompetition_type(String type) {
    this.competition_type = type;
  }
}

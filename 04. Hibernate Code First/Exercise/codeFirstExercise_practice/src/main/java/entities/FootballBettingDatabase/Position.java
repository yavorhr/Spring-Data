package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
  private String positionDescription;

  public Position() {
  }

  @Column(name = "position_description")
  public String getPositionDescription() {
    return this.positionDescription;
  }

  public void setPositionDescription(String positionDescription) {
    this.positionDescription = positionDescription;
  }
}

package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "competition_types")
public class CompetitionType extends BaseEntity {
    private String type;

  public CompetitionType(String type) {
    this.type = type;
  }

  public CompetitionType() {
  }

  @Column(name = "type", nullable = false)
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}

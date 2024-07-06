package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "teams")
public class Team extends BaseEntityWithName {
  private String logo;
  private InitialsEnum initials;
  private Color primaryKitColor;
  private Color secondaryKitColor;
  private Town town;
  private BigDecimal budget;

  public Team() {
  }

  public String getLogo() {
    return this.logo;
  }

  public InitialsEnum getInitials() {
    return this.initials;
  }

  public Color getPrimaryKitColor() {
    return this.primaryKitColor;
  }

  public Color getSecondaryKitColor() {
    return this.secondaryKitColor;
  }

  @ManyToOne
  public Town getTown() {
    return this.town;
  }

  public BigDecimal getBudget() {
    return this.budget;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public void setInitials(InitialsEnum initials) {
    this.initials = initials;
  }

  public void setPrimaryKitColor(Color primaryKitColor) {
    this.primaryKitColor = primaryKitColor;
  }

  public void setSecondaryKitColor(Color secondaryKitColor) {
    this.secondaryKitColor = secondaryKitColor;
  }

  public void setTown(Town town) {
    this.town = town;
  }

  public void setBudget(BigDecimal budget) {
    this.budget = budget;
  }
}

package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
  private String name;
  private String logo;
  private InitialsEnum initials;
  private Color primaryKitColor;
  private Color secondaryKitColor;
  private Town town;
  private BigDecimal budget;

  public Team() {
  }

  public Team(String name, String logo, InitialsEnum initials, Color primaryKitColor, Color secondaryKitColor, Town town, BigDecimal budget) {
    this.name = name;
    this.logo = logo;
    this.initials = initials;
    this.primaryKitColor = primaryKitColor;
    this.secondaryKitColor = secondaryKitColor;
    this.town = town;
    this.budget = budget;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  @Column(name = "logo")
  public String getLogo() {
    return this.logo;
  }

  @Column(name = "initials")
  public InitialsEnum getInitials() {
    return this.initials;
  }

  @ManyToOne
  public Color getPrimaryKitColor() {
    return this.primaryKitColor;
  }

  @ManyToOne
  public Color getSecondaryKitColor() {
    return this.secondaryKitColor;
  }

  @ManyToOne
  public Town getTown() {
    return this.town;
  }

  @Column(name = "budget", nullable = false)
  public BigDecimal getBudget() {
    return this.budget;
  }

  public void setName(String name) {
    this.name = name;
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

package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
  private String name;
  private short squadNumber;
  private Team team;
  private Position position;
  private boolean isInjured;

  public Player(String name, Position position, boolean isInjured) {
    this.name = name;
    this.position = position;
    this.isInjured = isInjured;
  }

  public Player() {
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return this.name;
  }

  @Column(name = "squad_number", length = 2)
  public short getSquadNumber() {
    return this.squadNumber;
  }

  @ManyToOne
  public Team getTeam() {
    return this.team;
  }

  @ManyToOne
  public Position getPosition() {
    return this.position;
  }

  @Column(name = "is_injured")
  public boolean isInjured() {
    return this.isInjured;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSquadNumber(short squadNumber) {
    this.squadNumber = squadNumber;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setInjured(boolean injured) {
    isInjured = injured;
  }
}

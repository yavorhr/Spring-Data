package entities.FootballBettingDatabase;

import entities.BaseEntity;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
  private Team homeTeam;
  private Team awayTeam;
  private short homeTeamGoals;
  private short awayTeamGoals;
  private LocalDateTime dateTime;
  private double homeTeamWinBetRate;
  private double awayTeamWinBetRate;
  private double drawTeamWinBetRate;
  private Round round;
  private Competition competition;

  public Game() {
  }

  @ManyToOne
  public Team getHomeTeam() {
    return this.homeTeam;
  }

  @ManyToOne
  public Team getAwayTeam() {
    return this.awayTeam;
  }

  @Column(name = "home_team_goals", nullable = false)
  public short getHomeTeamGoals() {
    return this.homeTeamGoals;
  }
  @Column(name = "away_team_goals",nullable = false )
  public short getAwayTeamGoals() {
    return this.awayTeamGoals;
  }

  @Column(name = "date_time",nullable = false )
  public LocalDateTime getDateTime() {
    return this.dateTime;
  }

  @Column(name = "home_team_win_bet_rate",nullable = false )
  public double getHomeTeamWinBetRate() {
    return this.homeTeamWinBetRate;
  }

  @Column(name = "away_team_win_bet_rate",nullable = false )
  public double getAwayTeamWinBetRate() {
    return this.awayTeamWinBetRate;
  }

  @Column(name = "draw_team_win_bet_rate",nullable = false )
  public double getDrawTeamWinBetRate() {
    return this.drawTeamWinBetRate;
  }

  @ManyToOne
  public Round getRound() {
    return this.round;
  }

  @ManyToOne
  public Competition getCompetition() {
    return this.competition;
  }

  public void setHomeTeam(Team homeTeam) {
    this.homeTeam = homeTeam;
  }

  public void setAwayTeam(Team awayTeam) {
    this.awayTeam = awayTeam;
  }

  public void setHomeTeamGoals(short homeTeamGoals) {
    this.homeTeamGoals = homeTeamGoals;
  }

  public void setAwayTeamGoals(short awayTeamGoals) {
    this.awayTeamGoals = awayTeamGoals;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
    this.homeTeamWinBetRate = homeTeamWinBetRate;
  }

  public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
    this.awayTeamWinBetRate = awayTeamWinBetRate;
  }

  public void setDrawTeamWinBetRate(double drawTeamWinBetRate) {
    this.drawTeamWinBetRate = drawTeamWinBetRate;
  }

  public void setRound(Round round) {
    this.round = round;
  }

  public void setCompetition(Competition competition) {
    this.competition = competition;
  }
}

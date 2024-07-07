package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistic extends BaseEntity {
  private int scoredGoals;
  private int playerAssists;
  private int playedMinutes;
  private Player player;
  private Game game;

  public PlayerStatistic() {
  }

  public int getScoredGoals() {
    return this.scoredGoals;
  }

  public int getPlayerAssists() {
    return this.playerAssists;
  }

  public int getPlayedMinutes() {
    return this.playedMinutes;
  }

  @ManyToOne
  public Player getPlayer() {
    return this.player;
  }

  @ManyToOne
  public Game getGame() {
    return this.game;
  }

  public void setScoredGoals(int scoredGoals) {
    this.scoredGoals = scoredGoals;
  }

  public void setPlayerAssists(int playerAssists) {
    this.playerAssists = playerAssists;
  }

  public void setPlayedMinutes(int playedMinutes) {
    this.playedMinutes = playedMinutes;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}

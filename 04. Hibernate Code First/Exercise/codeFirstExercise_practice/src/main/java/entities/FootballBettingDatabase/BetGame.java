package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bet_games")
public class BetGame extends BaseEntity {
  private Game game;
  private Bet bet;
  private ResultPrediction resultPrediction;

  public BetGame() {
  }

  @ManyToOne
  public Game getGame() {
    return this.game;
  }

  @ManyToOne
  public Bet getBet() {
    return this.bet;
  }

  @ManyToOne
  public ResultPrediction getResultPrediction() {
    return this.resultPrediction;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public void setBet(Bet bet) {
    this.bet = bet;
  }

  public void setResultPrediction(ResultPrediction resultPrediction) {
    this.resultPrediction = resultPrediction;
  }
}

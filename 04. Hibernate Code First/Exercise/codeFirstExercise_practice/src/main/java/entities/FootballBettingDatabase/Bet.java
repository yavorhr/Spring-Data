package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
  private BigDecimal betMoney;
  private LocalDateTime dateTime;
  private BettingUser user;

  public Bet() {
  }

  public BigDecimal getBetMoney() {
    return this.betMoney;
  }

  public LocalDateTime getDateTime() {
    return this.dateTime;
  }

  @ManyToOne
  public BettingUser getUser() {
    return this.user;
  }

  public void setBetMoney(BigDecimal betMoney) {
    this.betMoney = betMoney;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public void setUser(BettingUser user) {
    this.user = user;
  }
}

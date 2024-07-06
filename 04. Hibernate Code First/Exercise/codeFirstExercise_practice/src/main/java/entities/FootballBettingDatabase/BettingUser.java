package entities.FootballBettingDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "betting_users")
public class BettingUser extends BaseEntity {
  private String username;
  private String password;
  private String email;
  private String fullName;
  private BigDecimal balance;

  public BettingUser(String username, String password, String email, String fullName) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.fullName = fullName;
    this.balance = BigDecimal.ZERO;
  }

  public BettingUser() {
  }

  @Column(name = "username", nullable = false, unique = true)
  public String getUsername() {
    return this.username;
  }

  @Column(name = "password", nullable = false)
  public String getPassword() {
    return this.password;
  }

  @Column(name = "email", unique = true)
  public String getEmail() {
    return this.email;
  }

  @Column(name = "full_name", nullable = false)
  public String getFullName() {
    return this.fullName;
  }

  @Column(name = "balance")
  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}

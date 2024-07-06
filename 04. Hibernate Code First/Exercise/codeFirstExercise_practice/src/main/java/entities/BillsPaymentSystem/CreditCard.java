package entities.BillsPaymentSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
  private String cardType;
  private short expirationMonth;
  private short expirationYear;

  public CreditCard(String cardType, short expirationMonth, short expirationYear) {
    this.cardType = cardType;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
  }

  public CreditCard() {
  }

  @Column(name = "card_type", nullable = false)
  public String getCardType() {
    return cardType;
  }

  @Column(name = "expiration_month", nullable = false)
  public short getExpirationMonth() {
    return expirationMonth;
  }

  @Column(name = "expiration_year", nullable = false)
  public short getExpirationYear() {
    return expirationYear;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public void setExpirationMonth(short expirationMonth) {
    this.expirationMonth = expirationMonth;
  }

  public void setExpirationYear(short expirationYear) {
    this.expirationYear = expirationYear;
  }
}

package softuni.exam.models.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.annotation.Target;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

  private String name;
  private String code;
  private String currency;

  public Country() {
  }

  @Column(nullable = false,unique = true)
  public String getName() {
    return name;
  }

  @Column(nullable = false)
  public String getCode() {
    return code;
  }

  @Column(nullable = false)
  public String getCurrency() {
    return currency;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

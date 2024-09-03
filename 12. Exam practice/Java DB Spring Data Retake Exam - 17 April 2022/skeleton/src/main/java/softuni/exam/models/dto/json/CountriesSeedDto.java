package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountriesSeedDto {
  @Expose
  private String countryName;
  @Expose
  private String currency;

  @NotNull
  @Size(min = 2, max = 60)
  public String getCountryName() {
    return countryName;
  }

  @NotNull
  @Size(min = 2, max = 20)
  public String getCurrency() {
    return currency;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}

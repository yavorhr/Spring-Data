package softuni.exam.models.dto.json;

import com.google.gson.annotations.Expose;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountriesSeedDto {

  @Expose
  private String name;
  @Expose
  private String code;
  @Expose
  private String currency;

  @NotNull
  @Size(min = 2, max = 30)
  public String getName() {
    return name;
  }

  @NotNull
  @Size(min = 2, max = 19)
  public String getCode() {
    return code;
  }

  @NotNull
  @Size(min = 2, max = 19)
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

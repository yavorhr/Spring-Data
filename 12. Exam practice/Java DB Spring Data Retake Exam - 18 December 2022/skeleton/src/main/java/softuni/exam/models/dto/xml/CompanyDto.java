package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.Country;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "companies")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyDto {

  @XmlElement
  private String name;
  @XmlElement
  private String website;
  @XmlElement
  private LocalDate dateEstablished;
  private Long country;

  @NotBlank
  @Size(min = 2,max = 40)
  public String getName() {
    return name;
  }

  @NotBlank
  @Size(min = 2,max = 30)
  public String getWebsite() {
    return website;
  }

  @NotBlank
  @NotNull
  public LocalDate getDateEstablished() {
    return dateEstablished;
  }

  @NotBlank
  @NotNull
  public Long getCountry() {
    return country;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public void setDateEstablished(LocalDate dateEstablished) {
    this.dateEstablished = dateEstablished;
  }

  public void setCountry(Long country) {
    this.country = country;
  }
}

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

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyDto {

  @XmlElement(name = "companyName")
  private String name;
  @XmlElement
  private String website;
  @XmlElement
  private String dateEstablished;
  @XmlElement
  private Long countryId;

  public CompanyDto() {
  }

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
  public String getDateEstablished() {
    return dateEstablished;
  }

  public Long getCountryId() {
    return countryId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public void setDateEstablished(String dateEstablished) {
    this.dateEstablished = dateEstablished;
  }

  public void setCountryId(Long country) {
    this.countryId = country;
  }
}

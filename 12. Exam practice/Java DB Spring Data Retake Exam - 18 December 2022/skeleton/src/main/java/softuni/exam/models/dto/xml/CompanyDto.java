package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.Country;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyDto {

  @XmlElement(name = "companyName")
  private String name;
  @XmlElement
  private String website;
  @XmlElement
  private String dateEstablished;
  @XmlElement(name = "countryId")
  private Long country;

  @Size(min = 2,max = 40)
  public String getName() {
    return name;
  }

  @Size(min = 2,max = 30)
  public String getWebsite() {
    return website;
  }


  public String getDateEstablished() {
    return dateEstablished;
  }

  public Long getCountry() {
    return country;
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

  public void setCountry(Long country) {
    this.country = country;
  }
}

package softuni.exam.models.dto.xml;

import softuni.exam.models.entity.ApartmentTypeEnum;
import softuni.exam.models.entity.Town;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "apartment")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentDto {

  private ApartmentTypeEnum apartmentType;
  private Double area;
  private String town;

  @NotNull
  @Enumerated
  public ApartmentTypeEnum getApartmentType() {
    return apartmentType;
  }

  @NotNull
  @Min(40)
  public Double getArea() {
    return area;
  }

  public String getTown() {
    return town;
  }

  public void setApartmentType(ApartmentTypeEnum apartmentType) {
    this.apartmentType = apartmentType;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public void setTown(String town) {
    this.town = town;
  }
}

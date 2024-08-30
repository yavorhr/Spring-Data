package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity {
  private ApartmentTypeEnum apartmentType;
  private Double area;
  private Town town;

  public Apartment() {
  }

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  public ApartmentTypeEnum getApartmentType() {
    return apartmentType;
  }

  @Column(nullable = false)
  public Double getArea() {
    return area;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public void setApartmentType(ApartmentTypeEnum apartmentType) {
    this.apartmentType = apartmentType;
  }

  public void setArea(Double area) {
    this.area = area;
  }

  public void setTown(Town town) {
    this.town = town;
  }
}

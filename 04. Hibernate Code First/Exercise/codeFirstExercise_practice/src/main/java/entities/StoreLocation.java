package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "store_location")
public class StoreLocation extends BaseEntity {
  private String locationName;

  public StoreLocation() {
  }

  @Column(name = "location_name", nullable = false)
  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }
}
